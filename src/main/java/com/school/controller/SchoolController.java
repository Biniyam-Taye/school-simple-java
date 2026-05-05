package com.school.controller;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.service.StudentService;
import com.school.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SchoolController {
    private static final Logger log = LoggerFactory.getLogger(SchoolController.class);
    private final StudentService studentService;
    private final TeacherService teacherService;

    public SchoolController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        log.info("Interfacing with Executive Command Center...");
        List<Student> students = studentService.getAllStudents();
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);
        model.addAttribute("topScholars", studentService.getTopPerformers(5));
        model.addAttribute("avgAttendance", studentService.getAverageAttendance());
        model.addAttribute("dashboardTitle", studentService.getDashboardTitle());
        model.addAttribute("systemStability", studentService.getSystemStability());
        model.addAttribute("cognitiveVelocity", studentService.getCognitiveVelocity());
        model.addAttribute("regionalNodes", studentService.getRegionalNodes());
        model.addAttribute("recentActivity", studentService.getRecentActivity());
        
        java.util.Map<String, Long> gradeCounts = students.stream()
            .collect(java.util.stream.Collectors.groupingBy(Student::getGrade, java.util.stream.Collectors.counting()));
        model.addAttribute("gradeCounts", gradeCounts);

        double ratio = teachers.isEmpty() ? 0 : (double) students.size() / teachers.size();
        model.addAttribute("facultyRatio", String.format("%.1f", ratio));
        
        model.addAttribute("student", new Student());
        model.addAttribute("teacher", new Teacher());
        return "dashboard";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentService.enrollStudent(student);
        return "redirect:/";
    }

    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherService.appointFaculty(teacher);
        return "redirect:/";
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam Long id) {
        studentService.archiveStudentRecord(id);
        return "redirect:/";
    }

    @PostMapping("/delete-teacher")
    public String deleteTeacher(@RequestParam Long id) {
        teacherService.terminateContract(id);
        return "redirect:/";
    }

    @PostMapping("/edit-student")
    public String editStudent(@ModelAttribute Student student) {
        studentService.updateAcademicFile(student);
        return "redirect:/";
    }

    @PostMapping("/edit-teacher")
    public String editTeacher(@ModelAttribute Teacher teacher) {
        teacherService.updatePersonnelRecord(teacher);
        return "redirect:/";
    }
}
