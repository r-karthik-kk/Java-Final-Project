package com.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Department;


public interface DepartmentRepository 
        extends JpaRepository<Department, Long>{


    boolean existsByEmail(String email);


    boolean existsByDepartmentId(String departmentId);

    Optional<Department> findByDepartmentId(String departmentId);

}