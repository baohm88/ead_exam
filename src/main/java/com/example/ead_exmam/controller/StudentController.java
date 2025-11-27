package com.example.ead_exmam.controller;

import com.example.ead_exmam.entity.Student;
import com.example.ead_exmam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student s, Model m){
        try {
            service.save(s);
            return "redirect:/student/list";
        } catch (RuntimeException ex){
            m.addAttribute("student", s);
            m.addAttribute("error", ex.getMessage());
            return "add-student";
        }
    }

    @GetMapping("/list")
    public String list(Model m){
        m.addAttribute("students", service.list());
        return "students";
    }
}