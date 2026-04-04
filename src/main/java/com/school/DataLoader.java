package com.school;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed Students: id, first, last, email, grade, gpa, attendance
        studentRepository.save(new Student(null, "Alexander", "Sterling", "a.sterling@academy.edu", "Senior (12th)", 4.0, 99));
        studentRepository.save(new Student(null, "Elena", "Rodriguez", "e.rodriguez@academy.edu", "Senior (12th)", 3.9, 98));
        studentRepository.save(new Student(null, "Sophia", "Laurent", "s.laurent@academy.edu", "Sophomore (10th)", 3.8, 96));
        studentRepository.save(new Student(null, "Aria", "Night", "a.night@academy.edu", "Freshman (9th)", 3.9, 99));
        studentRepository.save(new Student(null, "Isabella", "Mikaelson", "i.mikaelson@academy.edu", "Sophomore (10th)", 4.0, 100));

        // Seed Teachers: id, first, last, subject, department
        teacherRepository.save(new Teacher(null, "Dr. Sebastian", "Wilde", "Advanced Physics", "Science"));
        teacherRepository.save(new Teacher(null, "Ms. Evelyn", "Blackwood", "European History", "Humanities"));
        teacherRepository.save(new Teacher(null, "Director Leo", "Drake", "Digital Innovation", "Technology"));
    }
}
