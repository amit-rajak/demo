package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.requests.StudentCreateRequest;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/student")
    public void createStudent(@RequestBody StudentCreateRequest studentCreateRequest)
    {
        studentService.addSudent(studentCreateRequest);
    }
    @GetMapping("/student")
    public Student getStudent(@RequestParam("id") int id)
    {
       return studentService.getStudent(id);
    }


}
