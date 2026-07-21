package com.backend.dto;


import lombok.Data;



@Data
public class FacultyRequest {


    private String facultyId;


    private String name;


    private String email;


    private String mobileNumber;


    private String password;


    private Long departmentId;


}