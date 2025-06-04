package com.example.demo_spring_data_jpa.repository;

import com.example.demo_spring_data_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
