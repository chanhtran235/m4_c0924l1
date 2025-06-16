package com.example.demo_spring_data_jpa.controller;

import com.example.demo_spring_data_jpa.dto.StudentDto;
import com.example.demo_spring_data_jpa.exception.DuplicateAdminName;
import com.example.demo_spring_data_jpa.model.Student;
import com.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class RestStudentController {
    @Autowired
    private IStudentService studentService;
//    @GetMapping("")
//    public ResponseEntity<List<Student>> getAll(){
//        List<Student> studentList = studentService.findAll();
//        if (studentList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 thanh công nhưng không có trả về giá trị
//        }
//        return new ResponseEntity<>(studentList,HttpStatus.OK); // 200 : thành công có trả về giá trị
//    }
    @GetMapping("")
    public ResponseEntity<Page<Student>> getAllPage(@PageableDefault(page = 0,size = 3)Pageable pageable){
        Page<Student> studentPage = studentService.findAll(pageable);
        if (studentPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 thanh công nhưng không có trả về giá trị
        }
        return new ResponseEntity<>(studentPage,HttpStatus.OK); // 200 : thành công có trả về giá trị
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id){
        Student student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        return new ResponseEntity<>(student,HttpStatus.OK);// 200
    }

    @PostMapping("")
    public ResponseEntity<Student> save(@RequestBody StudentDto studentDto) throws DuplicateAdminName {
        // validate
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);// 201 => thêm mới thành công
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        // validate
        Student student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody StudentDto studentDto) {
        // validate
        Student student = studentService.findById(id);
        if (student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);// 204
    }

}
