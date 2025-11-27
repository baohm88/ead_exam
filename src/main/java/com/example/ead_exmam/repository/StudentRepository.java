package com.example.ead_exmam.repository;

import com.example.ead_exmam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDeletedFalse();
    Optional<Student> findByCode(String code);
}
