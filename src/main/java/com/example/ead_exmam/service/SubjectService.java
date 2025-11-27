package com.example.ead_exmam.service;

import com.example.ead_exmam.entity.Subject;
import com.example.ead_exmam.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repo;

    public void save(Subject s){
        if(repo.findBySubjectCode(s.getSubjectCode()).isPresent()){
            throw new RuntimeException("Duplicate subject code: " + s.getSubjectCode());
        }
        repo.save(s);
    }

    public List<Subject> list(){
        return repo.findAll();
    }
}