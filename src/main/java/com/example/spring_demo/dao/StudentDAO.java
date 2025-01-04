package com.example.spring_demo.dao;

import com.example.spring_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student student);

    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}
