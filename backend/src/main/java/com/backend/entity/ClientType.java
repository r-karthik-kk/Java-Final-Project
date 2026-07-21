package com.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="client_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientType {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(
        name="type_name",
        unique=true,
        nullable=false
    )
    private String typeName;



    @Column(name="badge_color")
    private String badgeColor;



    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;



    @Column(name="created_at")
    private LocalDateTime createdAt;



    @Column(name="updated_at")
    private LocalDateTime updatedAt;



@OneToMany(
    mappedBy="clientType",
    cascade=CascadeType.ALL
)
private List<Client> clients;



    public enum Status{

        ACTIVE,
        INACTIVE

    }

}