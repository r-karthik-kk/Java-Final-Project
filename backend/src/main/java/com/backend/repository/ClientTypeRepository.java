package com.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.ClientType;


public interface ClientTypeRepository
extends JpaRepository<ClientType,Long>{


Optional<ClientType> findByTypeName(
        String typeName
);


}