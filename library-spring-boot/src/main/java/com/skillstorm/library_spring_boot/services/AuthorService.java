package com.skillstorm.library_spring_boot.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.library_spring_boot.models.Author;
import com.skillstorm.library_spring_boot.repositories.AuthorRepository;
import com.skillstorm.library_spring_boot.repositories.BooksRepository;

@Service
public class AuthorService {
    private AuthorRepository repo;

    // Use dependency injection to get an instance of the AuthorRepository
    public AuthorService(AuthorRepository repo) {
        this.repo = repo;
    }

    public Iterable<Author> findAll() {
        return repo.findAll();
    }

    public Optional<Author> findById(int id) {
        return repo.findById(id);
    }


    public Author save(Author author) {
        return repo.save(author);
    }

    public void update (int id, Author author) {
        if (!repo.existsById(id))
            throw new NoSuchElementException("Author with id " + id + " does not exist");
        author.setId(id); // ERROR - the method setBarcode(int) is undefined for the type Books
        repo.save(author);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}
