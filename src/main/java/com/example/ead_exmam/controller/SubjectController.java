package com.example.ead_exmam.controller;

import com.example.ead_exmam.entity.Subject;
import com.example.ead_exmam.repository.SubjectRepository;
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

    private final SubjectRepository subjectRepository;

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("subject", new Subject());
        return "add-subject";
    }

    @PostMapping("/save")
    public String save(Subject subject){
        subjectRepository.save(subject);
        return "redirect:/subject/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subjects";
    }
}