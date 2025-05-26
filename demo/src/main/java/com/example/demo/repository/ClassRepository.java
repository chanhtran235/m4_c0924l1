package com.example.demo.repository;

import com.example.demo.model.ClassCG;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRepository implements IClassRepository{
    private static List<ClassCG> classCGList = new ArrayList<>();
    static {
        classCGList.add(new ClassCG(1,"C09"));
        classCGList.add(new ClassCG(2,"C08"));
        classCGList.add(new ClassCG(3,"C07"));
    }
    @Override
    public List<ClassCG> findAll() {
        return classCGList;
    }
}
