package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chánh1"));
        studentList.add(new Student(2,"chánh2"));
    }
    @Override
    public List<Student> findAll() {
        // kết nối DB
        return studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()==id){
                return studentList.get(i);
            }
        }
        return null;
    }
}
