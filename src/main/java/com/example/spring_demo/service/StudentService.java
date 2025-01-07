package com.example.spring_demo.service;

import com.example.spring_demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();
    Optional<Student> findById(Integer id);

    void deleteById(Integer id);
    Student save (Student student);

}
