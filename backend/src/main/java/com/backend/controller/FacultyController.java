package com.backend.controller;


import org.springframework.web.bind.annotation.*;

import com.backend.dto.FacultyRequest;
import com.backend.entity.Faculty;
import com.backend.service.FacultyService;



@RestController
@RequestMapping("/api/faculty")
@CrossOrigin(origins="http://localhost:5173")
public class FacultyController {



private final FacultyService service;



public FacultyController(
        FacultyService service
){

    this.service=service;

}




@PostMapping
public Faculty create(
        @RequestBody FacultyRequest request
){

    return service.createFaculty(request);

}



}