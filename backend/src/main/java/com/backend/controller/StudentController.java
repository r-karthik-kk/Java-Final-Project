package com.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.backend.dto.StudentRequest;
import com.backend.dto.StudentResponse;
//import com.backend.entity.Student;
import com.backend.service.StudentService;



@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins="http://localhost:5173")
public class StudentController {



private final StudentService studentService;



public StudentController(
        StudentService studentService
){

    this.studentService = studentService;

}




@PostMapping
public ResponseEntity<StudentResponse> createStudent(
        @RequestBody StudentRequest request
){

    return ResponseEntity.ok(
        studentService.createStudent(request)
    );

}


}