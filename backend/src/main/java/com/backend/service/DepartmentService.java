package com.backend.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.dto.DepartmentRegisterRequest;
import com.backend.entity.Department;
import com.backend.repository.DepartmentRepository;


@Service
public class DepartmentService {


    private final DepartmentRepository repository;

    private final PasswordEncoder encoder;



    public DepartmentService(
            DepartmentRepository repository,
            PasswordEncoder encoder
    ){

        this.repository = repository;
        this.encoder = encoder;

    }




    public String register(
            DepartmentRegisterRequest request
    ){


        if(repository.existsByDepartmentId(
                request.getDepartmentId()
        )){

            return "Department ID already exists";

        }



        if(repository.existsByEmail(
                request.getEmail()
        )){

            return "Email already registered";

        }



        Department department = new Department();


        department.setDepartmentId(
                request.getDepartmentId()
        );


        department.setDepartmentName(
                request.getDepartmentName()
        );


        department.setEmail(
                request.getEmail()
        );


        department.setMobileNumber(
                request.getMobileNumber()
        );


        department.setPassword(
                encoder.encode(
                    request.getPassword()
                )
        );



        repository.save(department);



        return "Department registered successfully";


    }

}