package com.skillstorm.library_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.library_spring_boot.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

    
} 
