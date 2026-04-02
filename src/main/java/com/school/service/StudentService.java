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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void enrollStudent(Student student) {
        log.info("Admitting new student: {} {}", student.getFirstName(), student.getLastName());
        studentRepository.save(student);
    }

    public void archiveStudentRecord(Long id) {
        log.warn("Archiving student record with ID: {}", id);
        studentRepository.deleteById(id);
    }

    public void updateAcademicFile(Student student) {
        log.info("Updating academic scorecard for student: {}", student.getId());
        studentRepository.save(student);
    }
}
