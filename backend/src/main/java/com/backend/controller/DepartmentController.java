package com.backend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.dto.DepartmentRegisterRequest;
import com.backend.service.DepartmentService;


import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins="http://localhost:5173")
public class DepartmentController {



    private final DepartmentService service;



    public DepartmentController(
            DepartmentService service
    ){

        this.service = service;

    }




    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody DepartmentRegisterRequest request
    ){


        return ResponseEntity.ok(
                service.register(request)
        );


    }


}