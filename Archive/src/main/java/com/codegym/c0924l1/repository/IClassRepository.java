package com.codegym.c0924l1.repository;

import com.codegym.c0924l1.model.ClassCG;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClassRepository extends JpaRepository<ClassCG, Integer> {

}
