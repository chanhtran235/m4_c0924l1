package com.example.demo_spring_data_jpa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @Column(name = "gender")
    private int gender;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassCG classCG;

    @OneToOne
    @JoinColumn(name = "username", unique = true)
    private Jame jame;


}
