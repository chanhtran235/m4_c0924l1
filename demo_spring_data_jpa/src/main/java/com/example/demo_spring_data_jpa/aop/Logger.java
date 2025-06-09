package com.example.demo_spring_data_jpa.aop;

// dùng để xử lý nghiệp phụ => không làm ảnh hưởng đến nghiệp vụ chính

import com.example.demo_spring_data_jpa.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count =0;
    // advice là một hành đông
    @After("execution(* com.example.demo_spring_data_jpa.controller.HomeController.showHome(..))")
    public void countVisitedHomePage(){
        count++;
        System.out.println("------ visited home page number--------------"+count);
    }
//    @AfterReturning("execution(* com.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddStudent(JoinPoint joinPoint){
//        // lấy ra tên student được thêm mới
//        Object[] objects =joinPoint.getArgs();
//        StudentDto studentDtos = (StudentDto) objects[0];
//        System.out.println("------ new student ----" + studentDtos.getName());
//    }
//
//    @AfterThrowing("execution(* com.example.demo_spring_data_jpa.controller.StudentController.save(..))")
//    public void loggingAddStudentThrow(JoinPoint joinPoint){
//        // lấy ra tên student được thêm mới
//        Object[] objects =joinPoint.getArgs();
//        StudentDto studentDtos = (StudentDto) objects[0];
//        System.out.println("------ Tên trung với ----" + studentDtos.getName());
//    }

    @Around("execution(* com.example.demo_spring_data_jpa.controller.StudentController.save(..))")
    public Object loggingAround(ProceedingJoinPoint joinPoint){
        // lấy ra tên student được thêm mới
        System.out.println(" nghiẹp vụ phụ chạy trước nghiệp vụ chính");
        Object object= null;
        try {
           object = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(" nghiệp vụ phu chạy sau nghiệp vụ chính");
        return object;
    }




}
