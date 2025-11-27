package com.example.ead_exmam.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer id;

    @Column(name="student_code", nullable=false)
    private String code;

    @Column(name="full_name", nullable=false)
    private String name;

    private String address;
}