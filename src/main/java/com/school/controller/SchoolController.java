package com.school.controller;

import com.school.model.Student;
import com.school.model.Teacher;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SchoolController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("student", new Student());
        model.addAttribute("teacher", new Teacher());
        return "dashboard";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @PostMapping("/add-teacher")
    public String addTeacher(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/";
    }

    @PostMapping("/delete-student")
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/delete-teacher")
    public String deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/edit-student")
    public String editStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @PostMapping("/edit-teacher")
    public String editTeacher(@ModelAttribute Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/";
    }
}
