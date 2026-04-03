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
        // Seed Students: id, first, last, email, grade, gpa, attendance
        studentRepository.save(new Student(null, "Alexander", "Sterling", "a.sterling@academy.edu", "Senior (12th)", 4.0, 99));
        studentRepository.save(new Student(null, "Elena", "Rodriguez", "e.rodriguez@academy.edu", "Senior (12th)", 3.9, 98));
        studentRepository.save(new Student(null, "Marcus", "Chen", "m.chen@academy.edu", "Junior (11th)", 3.5, 94));
        studentRepository.save(new Student(null, "Sophia", "Laurent", "s.laurent@academy.edu", "Sophomore (10th)", 3.8, 96));
        studentRepository.save(new Student(null, "Julian", "Vance", "j.vance@academy.edu", "Senior (12th)", 3.2, 91));
        studentRepository.save(new Student(null, "Aria", "Night", "a.night@academy.edu", "Freshman (9th)", 3.9, 99));
        studentRepository.save(new Student(null, "Dominic", "Frost", "d.frost@academy.edu", "Junior (11th)", 3.4, 93));
        studentRepository.save(new Student(null, "Isabella", "Mikaelson", "i.mikaelson@academy.edu", "Sophomore (10th)", 4.0, 100));
        studentRepository.save(new Student(null, "Ethan", "Hunt", "e.hunt@academy.edu", "Senior (12th)", 3.7, 95));
        studentRepository.save(new Student(null, "Olivia", "Pope", "o.pope@academy.edu", "Junior (11th)", 3.9, 97));
        studentRepository.save(new Student(null, "Lucas", "Scott", "l.scott@academy.edu", "Freshman (9th)", 2.8, 82));
        studentRepository.save(new Student(null, "Maya", "Hart", "m.hart@academy.edu", "Sophomore (10th)", 3.6, 92));
        studentRepository.save(new Student(null, "Noah", "Flynn", "n.flynn@academy.edu", "Senior (12th)", 2.4, 75));
        studentRepository.save(new Student(null, "Chloe", "Decker", "c.decker@academy.edu", "Junior (11th)", 3.5, 96));
        studentRepository.save(new Student(null, "Liam", "Dunbar", "l.dunbar@academy.edu", "Sophomore (10th)", 3.1, 85));
        studentRepository.save(new Student(null, "Zoe", "Benson", "z.benson@academy.edu", "Freshman (9th)", 4.0, 100));

        // Seed Teachers: id, first, last, subject, department
        teacherRepository.save(new Teacher(null, "Dr. Sebastian", "Wilde", "Advanced Physics", "Science"));
        teacherRepository.save(new Teacher(null, "Prof. Amara", "Vane", "Quantum Mechanics", "Science"));
        teacherRepository.save(new Teacher(null, "Ms. Evelyn", "Blackwood", "European History", "Humanities"));
        teacherRepository.save(new Teacher(null, "Mr. Silas", "Crane", "Applied Mathematics", "STEM"));
        teacherRepository.save(new Teacher(null, "Madam Clara", "Hale", "Classical Literature", "Arts"));
        teacherRepository.save(new Teacher(null, "Director Leo", "Drake", "Digital Innovation", "Technology"));
        teacherRepository.save(new Teacher(null, "Dr. Victor", "Frank", "Biotechnology", "Science"));
        teacherRepository.save(new Teacher(null, "Prof. Diana", "Prince", "Ethics & Philosophy", "Humanities"));
        teacherRepository.save(new Teacher(null, "Mr. Bruce", "Wayne", "Strategic Management", "Business"));
        teacherRepository.save(new Teacher(null, "Ms. Selina", "Kyle", "Cyber Security", "Technology"));
    }
}
