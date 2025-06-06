package com.codegym.c0924l1.repository;

import com.codegym.c0924l1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
