package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String showList(ModelMap model){
        model.addAttribute("studentList", studentService.findAll());
        return "/students/list";
    }
//    public ModelAndView showList(){
//        ModelAndView modelAndView = new ModelAndView("/students/list");
//        modelAndView.addObject("studentList", studentService.findAll());
//        return modelAndView;
//    }
    @GetMapping("/add")
    public String showFormAdd(){
        return "students/add";
    }
    @PostMapping("/add")
    public String save(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes){
        Student student = new Student(id,name);
        // gọi service để thêm mới
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","add success");
        return "redirect:/students";
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam int id, Model model){
        // gọi service
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "students/detail";
    }
    @GetMapping("/{id:[1-5]}/detail")
    public String detail2(@PathVariable int id, Model model){
        // gọi service
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "students/detail";
    }
}
