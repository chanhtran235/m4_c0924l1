package com.codegym.c0924l1.controller;

import com.codegym.c0924l1.config.ClassCGEditor;
import com.codegym.c0924l1.model.ClassCG;
import com.codegym.c0924l1.model.Student;
import com.codegym.c0924l1.service.IClassService;
import com.codegym.c0924l1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    @Autowired
    private ClassCGEditor classCGEditor;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ClassCG.class, classCGEditor);
    }

    @ModelAttribute("languages")// ứng dụng tạo session => bài 10
    public List<String> getAllLanguage(){
        System.out.println("---------------------languages--------------------------");
        return Arrays.asList("JAVA","JS","PHP","SQL","C++");
    }
    @GetMapping("")
    public String showList(ModelMap model){
        model.addAttribute("studentList", studentService.findAll());
        return "/students/list";
    }
    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("classList", classService.findAll());
        return "students/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student, RedirectAttributes redirectAttributes){

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
    @GetMapping("/detail/{id}")
    public String detail2(@PathVariable int id, Model model){
        // gọi service
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "students/detail";
    }
}
