package com.backend.dto;


import lombok.Data;


@Data
public class StudentRequest {


    private String studentId;


    private String name;


    private String email;


    private String mobileNumber;


    private String departmentId;


    private Integer passingYear;


    private String about;


    private String password;


}