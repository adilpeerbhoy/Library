package com.skillstorm.library_spring_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.library_spring_boot.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

    @Query(value = "select a from Author a ORDER BY id LIMIT 3", nativeQuery = false)
    List<Author> findAll();

    Optional<Author> findById(int id);

    void deleteById(int id);
    

    List<Author> findByfirstname(String firstname);

    List<Author> findBylastname(String lastname);


} 
