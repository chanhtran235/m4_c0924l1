package com.example.demo_spring_data_jpa.service;

import com.example.demo_spring_data_jpa.exception.DuplicateAdminName;
import com.example.demo_spring_data_jpa.model.Student;
import com.example.demo_spring_data_jpa.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        /// xử lý nghiệp vụ
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(String searchName,Pageable pageable) {
        return studentRepository.findStudentByNameContaining(searchName,pageable);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void save(Student student){
        // nếu id của student tồn tại trong db thì update
        // nếu id không tồn tại thì thêm mới
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
