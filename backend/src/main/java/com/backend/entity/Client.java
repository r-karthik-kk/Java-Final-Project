package com.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
        name="client_id",
        unique=true,
        nullable=false
    )
    private String clientId;



    @Column(nullable=false)
    private String name;



    @Column(
        unique=true,
        nullable=false
    )
    private String email;



    @Column(nullable=false)
    private String password;



    @Column(name="mobile_number")
    private String mobileNumber;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name="client_type_id",
        nullable=false
    )
    private ClientType clientType;



    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;



    @Column(columnDefinition="TEXT")
    private String about;



    @Column(name="created_at")
    private LocalDateTime createdAt;



    @Column(name="updated_at")
    private LocalDateTime updatedAt;




    @PrePersist
    public void create(){

        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

    }



    @PreUpdate
    public void update(){

        updatedAt = LocalDateTime.now();

    }




    public enum Status{

        ACTIVE,
        INACTIVE

    }


}