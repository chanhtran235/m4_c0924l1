package com.example.demo_spring_data_jpa.repository;

import com.example.demo_spring_data_jpa.model.ClassCG;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClassRepository extends JpaRepository<ClassCG, Integer> {

}
