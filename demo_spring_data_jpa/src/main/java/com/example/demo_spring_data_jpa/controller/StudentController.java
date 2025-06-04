package com.example.demo_spring_data_jpa.controller;

import com.example.demo_spring_data_jpa.model.Student;
import com.example.demo_spring_data_jpa.service.IClassService;
import com.example.demo_spring_data_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;
//    @GetMapping("")
//    public String showList(ModelMap model){
//        model.addAttribute("studentList", studentService.findAll());
//        return "/students/list";
//    }
//    @GetMapping("")
//    public String showList(@PageableDefault(size = 2,sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
//                           @RequestParam(required = false,defaultValue = "") String searchName,
//                           ModelMap model){
//        Page<Student> studentPage = studentService.findAll(searchName,pageable);
//        model.addAttribute("studentPage", studentPage);
//        model.addAttribute("searchName", searchName);
//        return "/students/list";
//    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "2") int size,
                           @RequestParam(required = false,defaultValue = "0") int page,
                           @RequestParam(required = false,defaultValue = "") String searchName,
                           ModelMap model){
        Sort sort = Sort.by(Sort.Direction.ASC,"name").and(Sort.by( Sort.Direction.DESC,"gender"));
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> studentPage = studentService.findAll(searchName,pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
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
