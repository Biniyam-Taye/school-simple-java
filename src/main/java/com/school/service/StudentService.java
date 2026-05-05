package com.school.service;

import com.school.model.Student;
import com.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public String getDashboardTitle() {
        return "LUMINA_SUPREME_COMMAND_ZENITH";
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
        return List.of(
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
            .toList();
    }

    public String getAverageAttendance() {
        var students = studentRepository.findAll();
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
