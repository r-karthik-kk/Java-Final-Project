package com.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="faculty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
        name="faculty_id",
        unique=true,
        nullable=false
    )
    private String facultyId;



    @Column(nullable=false)
    private String name;



    @Column(
        unique=true,
        nullable=false
    )
    private String email;



    @Column(name="mobile_number")
    private String mobileNumber;



    @Column(nullable=false)
    private String password;



    @JsonIgnoreProperties({"faculties"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name="department_id",
        nullable=false
    )
    private Department department;



    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;



    @Column(name="created_at")
    private LocalDateTime createdAt;



    @Column(name="updated_at")
    private LocalDateTime updatedAt;




    @PrePersist
    public void beforeInsert(){

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

    }



    @PreUpdate
    public void beforeUpdate(){

        updatedAt = LocalDateTime.now();

    }



    public enum Status{

        ACTIVE,

        INACTIVE

    }

}