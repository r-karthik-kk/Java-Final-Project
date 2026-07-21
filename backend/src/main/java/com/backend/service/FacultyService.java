package com.backend.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.dto.FacultyRequest;
import com.backend.entity.Department;
import com.backend.entity.Faculty;
import com.backend.repository.DepartmentRepository;
import com.backend.repository.FacultyRepository;



@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;

    private final DepartmentRepository departmentRepository;

    private final PasswordEncoder passwordEncoder;



    public FacultyService(
            FacultyRepository facultyRepository,
            DepartmentRepository departmentRepository,
            PasswordEncoder passwordEncoder
    ){

        this.facultyRepository = facultyRepository;

        this.departmentRepository = departmentRepository;

        this.passwordEncoder = passwordEncoder;

    }





    public Faculty createFaculty(
            FacultyRequest request
    ){


        Department department =
            departmentRepository
            .findById(request.getDepartmentId())
            .orElseThrow(
                () -> new RuntimeException(
                    "Department not found"
                )
            );



        Faculty faculty = new Faculty();



        faculty.setFacultyId(
            request.getFacultyId()
        );



        faculty.setName(
            request.getName()
        );



        faculty.setEmail(
            request.getEmail()
        );



        faculty.setMobileNumber(
            request.getMobileNumber()
        );



        /*
         * Encrypt password using BCrypt
         */
        faculty.setPassword(
            passwordEncoder.encode(
                request.getPassword()
            )
        );



        faculty.setDepartment(
            department
        );



        return facultyRepository.save(faculty);

    }


}