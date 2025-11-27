package com.example.ead_exmam.controller;

import com.example.ead_exmam.entity.StudentScore;
import com.example.ead_exmam.repository.StudentRepository;
import com.example.ead_exmam.repository.StudentScoreRepository;
import com.example.ead_exmam.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {
    private final StudentScoreRepository scoreRepo;
    private final StudentRepository studentRepo;
    private final SubjectRepository subjectRepo;

    @GetMapping("/add")
    public String form(Model m){
        m.addAttribute("students", studentRepo.findAll());
        m.addAttribute("subjects", subjectRepo.findAll());
        m.addAttribute("score", new StudentScore());
        return "add-score";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentScore score){
        scoreRepo.save(score);
        return "redirect:/";
    }
}
