package com.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Faculty;


import java.util.Optional;



public interface FacultyRepository 
        extends JpaRepository<Faculty,Long>{


    boolean existsByFacultyId(String facultyId);

    boolean existsByEmail(String email);
    
    Optional<Faculty> findByFacultyId(String facultyId);


    Optional<Faculty> findByEmail(String email);

}