package com.school;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public DataLoader(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed Students: id, first, last, email, grade, gpa, attendance
        studentRepository.save(new Student(null, "Alexander", "Sterling", "a.sterling@lumina.edu", "Senior (Elite)", 4.0, 99));
        studentRepository.save(new Student(null, "Elena", "Rodriguez", "e.rodriguez@lumina.edu", "Senior (Elite)", 3.9, 98));
        studentRepository.save(new Student(null, "Sophia", "Laurent", "s.laurent@lumina.edu", "Sophomore (Advanced)", 3.8, 96));
        studentRepository.save(new Student(null, "Aria", "Night", "a.night@lumina.edu", "Freshman (Standard)", 3.9, 99));
        studentRepository.save(new Student(null, "Isabella", "Mikaelson", "i.mikaelson@lumina.edu", "Sophomore (Advanced)", 4.0, 100));
        studentRepository.save(new Student(null, "Lucas", "Vance", "l.vance@lumina.edu", "Junior (Honors)", 3.7, 95));
        studentRepository.save(new Student(null, "Maya", "Chen", "m.chen@lumina.edu", "Senior (Elite)", 3.95, 98));
        studentRepository.save(new Student(null, "Julian", "Black", "j.black@lumina.edu", "Junior (Honors)", 3.6, 94));
        studentRepository.save(new Student(null, "Olivia", "Wilder", "o.wilder@lumina.edu", "Freshman (Standard)", 3.85, 97));
        studentRepository.save(new Student(null, "Ethan", "Hawthorne", "e.hawthorne@lumina.edu", "Sophomore (Advanced)", 3.75, 96));
        studentRepository.save(new Student(null, "Zoe", "Kravitz", "z.kravitz@lumina.edu", "Junior (Honors)", 3.9, 98));
        studentRepository.save(new Student(null, "Liam", "Nolan", "l.nolan@lumina.edu", "Senior (Elite)", 3.8, 95));
        studentRepository.save(new Student(null, "Nathan", "Drake", "n.drake@lumina.edu", "Freshman (Standard)", 3.5, 92));
        studentRepository.save(new Student(null, "Chloe", "Frazer", "c.frazer@lumina.edu", "Sophomore (Advanced)", 3.92, 99));
        studentRepository.save(new Student(null, "Victor", "Sullivan", "v.sullivan@lumina.edu", "Senior (Elite)", 3.78, 94));
        studentRepository.save(new Student(null, "Lara", "Croft", "l.croft@lumina.edu", "Junior (Honors)", 4.0, 100));
        studentRepository.save(new Student(null, "Sam", "Fisher", "s.fisher@lumina.edu", "Freshman (Standard)", 3.4, 90));
        studentRepository.save(new Student(null, "Jill", "Valentine", "j.valentine@lumina.edu", "Sophomore (Advanced)", 3.88, 97));
        studentRepository.save(new Student(null, "Leon", "Kennedy", "l.kennedy@lumina.edu", "Senior (Elite)", 3.96, 98));

        // Seed Teachers: id, first, last, subject, department
        teacherRepository.save(new Teacher(null, "Dr. Sebastian", "Wilde", "QUANTUM_GRID_DYNAMICS", "CORE_SCI_SECTOR"));
        teacherRepository.save(new Teacher(null, "Ms. Evelyn", "Blackwood", "GLOBAL_STRATEGIC_INTEL", "DIRECTORATE_HUMANITIES"));
        teacherRepository.save(new Teacher(null, "Director Leo", "Drake", "NEURAL_NETWORK_ARCHITECTURE", "TECH_OMNI_NODE"));
        teacherRepository.save(new Teacher(null, "Prof. Julian", "Thorne", "EXECUTIVE_MACRO_STRATEGY", "FINANCIAL_INTELLIGENCE"));
        teacherRepository.save(new Teacher(null, "Dr. Sarah", "Connor", "ROBOTIC_KINETIC_SYSTEMS", "CORE_SCI_SECTOR"));
        teacherRepository.save(new Teacher(null, "Mr. Arthur", "Morgan", "HISTORICAL_RESONANCE_LOG", "DIRECTORATE_HUMANITIES"));
        teacherRepository.save(new Teacher(null, "Ms. Diana", "Prince", "ANCIENT_TACTICAL_STUDIES", "DIRECTORATE_HUMANITIES"));
        teacherRepository.save(new Teacher(null, "Dr. Bruce", "Wayne", "OPERATIONAL_RISK_MANAGEMENT", "FINANCIAL_INTELLIGENCE"));
        teacherRepository.save(new Teacher(null, "Prof. Albus", "Dumbledore", "ETHICAL_LEADERSHIP_PROTOCOL", "DIRECTORATE_HUMANITIES"));
        teacherRepository.save(new Teacher(null, "Ms. Ada", "Lovelace", "COMPUTATIONAL_LOGIC_MATRIX", "TECH_OMNI_NODE"));
    }
}
