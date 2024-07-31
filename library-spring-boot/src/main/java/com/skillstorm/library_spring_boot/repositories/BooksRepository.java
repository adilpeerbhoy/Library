package com.skillstorm.library_spring_boot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import com.skillstorm.library_spring_boot.models.Books;
import com.skillstorm.library_spring_boot.models.Author;
import com.skillstorm.library_spring_boot.models.Genre;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Query(value = "select b from Books b ORDER BY status LIMIT 3", nativeQuery = false)
    @EntityGraph(value = "Books.withAuthor", type = EntityGraphType.LOAD)

    List<Books> findByStatus(String status);

    List<Books> findByAuthor(Author author);

    List<Books> findByGenre(Genre genre);

    Optional<Books> findByBarcode(int barcode);

    void deleteByBarcode(int barcode);
    
} 
