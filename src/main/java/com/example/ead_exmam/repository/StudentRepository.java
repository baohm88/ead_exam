package com.example.ead_exmam.repository;

import com.example.ead_exmam.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
