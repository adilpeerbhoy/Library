package com.skillstorm.library_spring_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.library_spring_boot.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{
    @Query(value = "select g from Genre g ORDER BY id LIMIT 3", nativeQuery = false)
    List<Genre> findAll();

    Optional<Genre> findById(int id);

    void deleteById(int id);


    List<Genre> findByGenre(String genre);



} 