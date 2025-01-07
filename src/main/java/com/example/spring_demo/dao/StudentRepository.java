package com.example.spring_demo.dao;

import com.example.spring_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// substitutes StudentDAO implementation
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
