package com.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
        name="student_id",
        unique=true,
        nullable=false
    )
    private String studentId;



    @Column(nullable=false)
    private String name;



    @Column(
        unique=true,
        nullable=false
    )
    private String email;



    @Column(name="mobile_number")
    private String mobileNumber;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name="department_id",
        referencedColumnName="department_id",
        nullable=false
    )
    private Department department;



    @Column(name="passing_year")
    private Integer passingYear;



    @Column(columnDefinition="TEXT")
    private String about;



    @Column(nullable=false)
    private String password;



    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;



    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;



    @PrePersist
    public void onCreate(){

        createdAt = LocalDateTime.now();

        updatedAt = LocalDateTime.now();

    }



    @PreUpdate
    public void onUpdate(){

        updatedAt = LocalDateTime.now();

    }




    public enum Status{

        ACTIVE,

        INACTIVE

    }


}