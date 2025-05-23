package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add(Student student);
    Student findById(int id);
}
