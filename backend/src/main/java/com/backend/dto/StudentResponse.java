package com.backend.dto;


import lombok.Data;


@Data
public class StudentResponse {


    private Long id;

    private String studentId;

    private String name;

    private String email;

    private String mobileNumber;

    private String department;

    private Integer passingYear;

    private String about;

    private String status;


}