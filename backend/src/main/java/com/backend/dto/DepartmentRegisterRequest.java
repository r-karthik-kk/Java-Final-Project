package com.backend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class DepartmentRegisterRequest {


    @NotBlank
    private String departmentId;


    @NotBlank
    private String departmentName;


    @Email
    @NotBlank
    private String email;


    private String mobileNumber;


    @NotBlank
    private String password;


}