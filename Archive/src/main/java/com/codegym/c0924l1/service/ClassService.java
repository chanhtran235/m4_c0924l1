package com.codegym.c0924l1.service;

import com.codegym.c0924l1.model.ClassCG;
import com.codegym.c0924l1.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClassService implements IClassService{
    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }

    @Override
    public ClassCG findById(int id) {
        return classRepository.findById(id).orElse(null);
    }
}
