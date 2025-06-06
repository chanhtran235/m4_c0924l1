package com.codegym.c0924l1.service;

import com.codegym.c0924l1.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
    Student findById(int id);
}
