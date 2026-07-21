package com.backend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "departments")
@Data
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
        name = "department_id",
        unique = true,
        nullable = false
    )
    private String departmentId;



    @Column(
        name = "department_name",
        nullable = false
    )
    private String departmentName;



    @Column(
        unique = true,
        nullable = false
    )
    private String email;



    @Column(name = "mobile_number")
    private String mobileNumber;



    @Column(nullable = false)
    private String password;



    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;



    @Column(name = "created_at")
    private LocalDateTime createdAt;



    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    @JsonIgnore
    @OneToMany(
        mappedBy = "department",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Faculty> faculties = new ArrayList<>();

    @OneToMany(
        mappedBy="department"
    )
    private List<Student> students;



    @PrePersist
    public void beforeInsert(){

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

    }



    @PreUpdate
    public void beforeUpdate(){

        updatedAt = LocalDateTime.now();

    }



    public enum Status {

        ACTIVE,
        INACTIVE

    }

}