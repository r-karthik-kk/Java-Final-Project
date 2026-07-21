package com.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Client;



public interface ClientRepository 
extends JpaRepository<Client, Long>{



    boolean existsByClientId(
            String clientId
    );



    boolean existsByEmail(
            String email
    );

    Optional<Client> findByClientId(String clientId);

}