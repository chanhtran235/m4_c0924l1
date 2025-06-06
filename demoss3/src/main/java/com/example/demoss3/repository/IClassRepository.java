package com.example.demoss3.repository;

import com.example.demoss3.model.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
    ClassCG findById(int id);
}
