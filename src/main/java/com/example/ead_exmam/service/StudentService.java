package com.example.ead_exmam.service;

import com.example.ead_exmam.entity.Student;
import com.example.ead_exmam.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public void save(Student s){
        if(repo.findByCode(s.getCode()).isPresent()){
            throw new RuntimeException("Duplicate student code: " + s.getCode());
        }
        repo.save(s);
    }

    public List<Student> list(){
        return repo.findAll();
    }
}