package com.example.demo_spring_data_jpa.repository;

import com.example.demo_spring_data_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    // tạo câu truy vấn bằng methodname
  Page<Student> findStudentByNameContaining(String searchName, Pageable pageable);
  // sử câu where thuần?

}
