package com.example.spring_demo.dao;

import com.example.spring_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// substitutes StudentDAO implementation
// @RepositoryRestResource(path = "members")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
