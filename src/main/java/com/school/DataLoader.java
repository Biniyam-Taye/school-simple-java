package com.school;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed Students
        studentRepository.save(new Student(null, "Alice", "Johnson", "alice@edu.com", "12th Grade"));
        studentRepository.save(new Student(null, "Bob", "Smith", "bob@edu.com", "11th Grade"));
        studentRepository.save(new Student(null, "Charlie", "Brown", "charlie@edu.com", "10th Grade"));
        studentRepository.save(new Student(null, "David", "Wilson", "david@edu.com", "9th Grade"));
        studentRepository.save(new Student(null, "Eva", "Garcia", "eva@edu.com", "12th Grade"));

        // Seed Teachers
        teacherRepository.save(new Teacher(null, "John", "Doe", "Physics", "Science"));
        teacherRepository.save(new Teacher(null, "Jane", "Smith", "History", "Humanities"));
        teacherRepository.save(new Teacher(null, "Michael", "Vance", "Mathematics", "STEM"));
        teacherRepository.save(new Teacher(null, "Sarah", "Connor", "Art & Design", "Creative Arts"));
    }
}
