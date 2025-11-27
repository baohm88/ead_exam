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

    private String subjectCode;
    private String subjectName;
    private Integer credit;
}