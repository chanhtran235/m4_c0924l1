package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.model.ClassCG;

import java.util.List;

public interface IClassService {
    List<ClassCG> findAll();
    ClassCG findById(int id);
}
