package com.example.ead_exmam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student_score_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentScoreId;

    @ManyToOne @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne @JoinColumn(name="subject_id")
    private Subject subject;

    private Double score1;
    private Double score2;

    @Transient
    public String getGrade(){
        double g = 0.3*score1 + 0.7*score2;
        if(g >= 8) return "A";
        if(g >= 6) return "B";
        if(g >= 4) return "D";
        return "F";
    }
}