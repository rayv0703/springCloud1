package com.broada.controller;

import com.broada.domain.Student;
import com.broada.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    @RequestMapping("/findBySid")
    public Student findBySid(Integer sid){
        Optional<Student> optional = studentService.findById(sid);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            return null;
        }
    }
}
