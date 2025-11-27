package com.example.ead_exmam.controller;

import com.example.ead_exmam.entity.Subject;
import com.example.ead_exmam.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService service;

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("subject", new Subject());
        return "add-subject";
    }

    @PostMapping("/save")
    public String save(Subject subject, Model model){
        try {
            service.save(subject);
            return "redirect:/subject/list";
        } catch (RuntimeException ex){
            model.addAttribute("subject", subject);
            model.addAttribute("error", ex.getMessage());
            return "add-subject";
        }
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("subjects", service.list());
        return "subjects";
    }
}