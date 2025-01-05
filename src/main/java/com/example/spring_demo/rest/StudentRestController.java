package com.example.spring_demo.rest;

import com.example.spring_demo.entity.StudentRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentRecord> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new StudentRecord("Porrima", "Patel"));
        theStudents.add(new StudentRecord("Mario", "Rossi"));
        theStudents.add(new StudentRecord("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<StudentRecord> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public StudentRecord getStudent(@PathVariable Integer studentId){

        if(studentId >= theStudents.size() || studentId < 0){
            throw new RuntimeException("Student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }

    /*
    * Move to StudentExceptionHandler.java

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(RuntimeException exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

     */
}
