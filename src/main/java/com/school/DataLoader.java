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
        String[] grades = {"Freshman (9th)", "Sophomore (10th)", "Junior (11th)", "Senior (12th)"};
        String[] firstNames = {"Alexander", "Elena", "Marcus", "Sophia", "Julian", "Aria", "Dominic", "Isabella", "Ethan", "Olivia", "Lucas", "Maya", "Noah", "Chloe", "Liam", "Zoe", "Benjamin", "Catherine", "Daniel", "Elizabeth", "Finn", "Gabriel", "Hailey", "Isaac", "Jada", "Kaleb", "Lia", "Milo", "Nora", "Owen"};
        String[] lastNames = {"Sterling", "Rodriguez", "Chen", "Laurent", "Vance", "Night", "Frost", "Mikaelson", "Hunt", "Pope", "Scott", "Hart", "Flynn", "Decker", "Dunbar", "Benson", "Franklin", "Zeta", "Craig", "Windsor", "Hudson", "Knight", "Bieber", "Newton", "Pinkett", "Mendes", "Cabello", "Puth", "Eilish", "Grande"};

        for (int i = 0; i < 100; i++) {
            String f = firstNames[i % firstNames.length] + (i > 29 ? i : "");
            String l = lastNames[i % lastNames.length];
            String g = grades[i % grades.length];
            double gpa = 2.4 + (Math.random() * 1.6);
            int attendance = 65 + (int)(Math.random() * 35);
            studentRepository.save(new Student(null, f, l, f.toLowerCase() + "." + l.toLowerCase() + "@academy.edu", g, Math.round(gpa * 100.0) / 100.0, attendance));
        }

        // Seed Teachers: id, first, last, subject, department
        teacherRepository.save(new Teacher(null, "Dr. Sebastian", "Wilde", "Advanced Physics", "Science"));
        teacherRepository.save(new Teacher(null, "Ms. Evelyn", "Blackwood", "European History", "Humanities"));
        teacherRepository.save(new Teacher(null, "Director Leo", "Drake", "Digital Innovation", "Technology"));
        teacherRepository.save(new Teacher(null, "Prof. Diana", "Prince", "Ethics & Philosophy", "Humanities"));
        teacherRepository.save(new Teacher(null, "Mr. Bruce", "Wayne", "Strategic Management", "Business"));
        teacherRepository.save(new Teacher(null, "Dr. Alfred", "Pennyworth", "Advanced Sociology", "Humanities"));
        teacherRepository.save(new Teacher(null, "Mr. Tony", "Stark", "Robotics & AI", "Technology"));
        teacherRepository.save(new Teacher(null, "Dr. Stephen", "Strange", "Theoretical Geometry", "STEM"));
    }
}
