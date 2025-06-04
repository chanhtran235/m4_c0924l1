package com.example.demo_spring_data_jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @Column(name = "gender")
    private int gender;

//    private List<String> languages;
    // lớp học

//    private String classCG;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

//    public ClassCG getClassCG() {
//        return classCG;
//    }
//
//    public void setClassCG(ClassCG classCG) {
//        this.classCG = classCG;
//    }

    public Student(Integer id, String name, int gender, List<String> languages) {
        this.id = id;
        this.name = name;
        this.gender = gender;
//        this.languages = languages;
    }

    public Student(Integer id, String name, int gender, List<String> languages, ClassCG classCG) {
        this.id = id;
        this.name = name;
        this.gender = gender;
//        this.languages = languages;
//        this.classCG = classCG;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

//    public List<String> getLanguages() {
//        return languages;
//    }
//
//    public void setLanguages(List<String> languages) {
//        this.languages = languages;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
