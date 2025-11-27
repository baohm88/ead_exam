package com.example.ead_exmam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "score_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(nullable = false)
    private Double score1;

    @Column(nullable = false)
    private Double score2;

    @Column(nullable = false)
    private boolean deleted = false;

    @Transient
    public String getGrade() {
        double g = 0.3 * score1 + 0.7 * score2;
        if (g >= 8) return "A";
        if (g >= 6) return "B";
        if (g >= 4) return "D";
        return "F";
    }
}