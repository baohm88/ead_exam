package com.example.ead_exmam.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="subject_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    private Integer id;

    @Column(name="subject_code", unique = true, nullable = false)
    private String subjectCode;
    private String subjectName;
    private Integer credit;

    @Column(nullable = false)
    private boolean deleted = false;
}