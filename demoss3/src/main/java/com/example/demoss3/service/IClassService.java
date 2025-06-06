package com.example.demoss3.service;

import com.example.demoss3.model.ClassCG;

import java.util.List;

public interface IClassService {
    List<ClassCG> findAll();
    ClassCG findById(int id);
}
