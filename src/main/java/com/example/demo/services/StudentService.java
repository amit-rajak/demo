package com.example.demo.services;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.requests.StudentCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addSudent(StudentCreateRequest studentCreateRequest)
    {
        Student student=studentCreateRequest.toStudent();
        studentRepository.save(student);
    }
    public Student getStudent(int id)
    {
        return studentRepository.findById(id).orElse(null);
    }
}
