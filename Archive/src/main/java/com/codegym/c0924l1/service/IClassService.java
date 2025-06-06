package com.codegym.c0924l1.service;

import com.codegym.c0924l1.model.ClassCG;

import java.util.List;

public interface IClassService {
    List<ClassCG> findAll();
    ClassCG findById(int id);
}
