package com.school.service;

import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String getDashboardTitle() {
        return "PANTHEON_DIRECTORATE_ETERNAL_GRID";
    }

    public String getSystemStability() {
        return "99.9%_SYSTEM_INTEGRITY";
    }

    public String getCognitiveVelocity() {
        return "184.2_CV_INDEX";
    }

    public String getRegionalNodes() {
        return "08_REGIONAL_ACADEMIC_NODES";
    }

    public List<String> getRecentActivity() {
        return Arrays.asList(
            "CORE_OS_UPGRADE_SYNC_V4.2 [STABLE]",
            "NEURAL_GRADIENT_OPTIMIZATION_COMPLETE",
            "DIRECTORATE_IDENTITY_AUTHENTICATED [B. TAYE]",
            "SECTOR_ALPHA_RESOURCE_REBALANCE_NOMINAL"
        );
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getTopPerformers(int limit) {
        return studentRepository.findAll().stream()
            .sorted((s1, s2) -> s2.getGpa().compareTo(s1.getGpa()))
            .limit(limit)
            .collect(Collectors.toList());
    }

    public String getAverageAttendance() {
        List<Student> students = studentRepository.findAll();
        double avg = students.isEmpty() ? 0 : 
            students.stream().mapToInt(Student::getAttendance).average().orElse(0.0);
        return String.format("%.1f", avg);
    }

    public void enrollStudent(Student student) {
        log.info("INITIATING_ASSET_ONBOARDING: {} {}", student.getFirstName(), student.getLastName());
        studentRepository.save(student);
    }

    public void archiveStudentRecord(Long id) {
        log.warn("EXECUTING_RECORD_DECOMMISSION: ID {}", id);
        studentRepository.deleteById(id);
    }

    public void updateAcademicFile(Student student) {
        log.info("RECALIBRATING_ASSET_SIGNATURE: {}", student.getId());
        studentRepository.save(student);
    }
}
