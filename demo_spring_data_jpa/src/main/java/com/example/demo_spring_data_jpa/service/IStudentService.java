package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Page<Student> findAll(String searchName,Pageable pageable);
    Page<Student> findAll(Pageable pageable);
    void save(Student student);
    void deleteById(int id);
    Student findById(int id);
}
