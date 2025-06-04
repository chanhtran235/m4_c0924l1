package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
    Student findById(int id);
}
