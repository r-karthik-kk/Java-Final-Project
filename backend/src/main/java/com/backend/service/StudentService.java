package com.backend.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.backend.dto.StudentRequest;
import com.backend.dto.StudentResponse;
import com.backend.entity.Department;
import com.backend.entity.Student;
import com.backend.repository.DepartmentRepository;
import com.backend.repository.StudentRepository;



@Service
public class StudentService {


    private final StudentRepository studentRepository;

    private final DepartmentRepository departmentRepository;

    private final PasswordEncoder passwordEncoder;



    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository,
            PasswordEncoder passwordEncoder
    ){

        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.passwordEncoder = passwordEncoder;

    }





    public StudentResponse createStudent(
            StudentRequest request
    ){


        if(studentRepository.existsByStudentId(
                request.getStudentId()
        )){

            throw new RuntimeException(
                "Student ID already exists"
            );

        }



        if(studentRepository.existsByEmail(
                request.getEmail()
        )){

            throw new RuntimeException(
                "Email already registered"
            );

        }





        Department department =
                departmentRepository
                .findAll()
                .stream()
                .filter(
                    dept -> dept.getDepartmentId()
                    .equals(request.getDepartmentId())
                )
                .findFirst()
                .orElseThrow(
                    () -> new RuntimeException(
                        "Department not found"
                    )
                );





        Student student = new Student();



        student.setStudentId(
            request.getStudentId()
        );


        student.setName(
            request.getName()
        );


        student.setEmail(
            request.getEmail()
        );


        student.setMobileNumber(
            request.getMobileNumber()
        );


        student.setDepartment(
            department
        );


        student.setPassingYear(
            request.getPassingYear()
        );


        student.setAbout(
            request.getAbout()
        );



        student.setPassword(
            passwordEncoder.encode(
                request.getPassword()
            )
        );



Student saved =
        studentRepository.save(student);



StudentResponse response =
        new StudentResponse();


response.setId(
        saved.getId()
);


response.setStudentId(
        saved.getStudentId()
);


response.setName(
        saved.getName()
);


response.setEmail(
        saved.getEmail()
);


response.setMobileNumber(
        saved.getMobileNumber()
);


response.setDepartment(
        saved.getDepartment()
        .getDepartmentName()
);


response.setPassingYear(
        saved.getPassingYear()
);


response.setAbout(
        saved.getAbout()
);


response.setStatus(
        saved.getStatus()
        .name()
);



return response;

    }


}