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
        return "AFRINIA_ACADEMIC_COMMAND";
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
        log.info("ENROLLING_STUDENT: {} {}", student.getFirstName(), student.getLastName());
        studentRepository.save(student);
    }

    public void archiveStudentRecord(Long id) {
        log.warn("DELETING_STUDENT_RECORD: ID {}", id);
        studentRepository.deleteById(id);
    }

    public void updateAcademicFile(Student student) {
        log.info("UPDATING_STUDENT_METRICS: {}", student.getId());
        studentRepository.save(student);
    }
}
