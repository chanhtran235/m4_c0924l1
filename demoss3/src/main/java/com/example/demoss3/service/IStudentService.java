package com.example.demoss3.service;

import com.example.demoss3.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
    Student findById(int id);
}
