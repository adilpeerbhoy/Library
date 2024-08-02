package com.skillstorm.library_spring_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.library_spring_boot.models.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    @Query(value = "select l from Library l ORDER BY id LIMIT 3", nativeQuery = false)
    List<Library> findAll();

    Optional<Library> findById(int id);

    @SuppressWarnings("unchecked")
    Library save(Library library);

    void deleteById(int id);
    
}
