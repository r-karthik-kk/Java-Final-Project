package com.backend.dto;


import lombok.Data;


@Data
public class ClientRequest {


    private String clientId;


    private String name;


    private String email;


    private String mobileNumber;


    private String password;


    private Long clientTypeId;


    private String about;


}