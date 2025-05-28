package com.example.demo.repository;

import com.example.demo.model.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
    ClassCG findById(int id);
}
