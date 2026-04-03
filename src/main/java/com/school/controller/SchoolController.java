package com.school.controller;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.service.StudentService;
import com.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SchoolController {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping("/")
    public String dashboard(Model model) {
        log.info("Interfacing with Executive Command Center...");
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        model.addAttribute("topScholars", studentService.getTopScholars(5));
        model.addAttribute("avgAttendance", studentService.getAverageAttendance());
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
