package com.example.spring_demo.rest;

import com.example.spring_demo.entity.Student;
import com.example.spring_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {


//    private StudentDAO studentDAO;  // use StudentService instead
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }


    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudent(@PathVariable Integer studentId){

        Optional<Student> student = studentService.findById(studentId);

        if(student.isEmpty()){
            throw new RuntimeException("Student id not found: " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student newStudent){
        newStudent.setId(0);
        return studentService.save(newStudent);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId){

        Optional<Student> student = studentService.findById(studentId);

        if(student.isEmpty()){
            throw new RuntimeException("Student id not found: " + studentId);
        }

        studentService.deleteById(studentId);
        return "Deleted student: " + student;
    }
}
