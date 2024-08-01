package com.skillstorm.library_spring_boot.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.library_spring_boot.models.Genre;
import com.skillstorm.library_spring_boot.repositories.GenreRepository;

@Service
public class GenreService {
    private GenreRepository repo;

    // Use dependency injection to get an instance of the AuthorRepository
    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    public Iterable<Genre> findAll() {
        return repo.findAll();
    }

    public Optional<Genre> findById(int id) {
        return repo.findById(id);
    }


    public Genre save(Genre genre) {
        return repo.save(genre);
    }

    public void update (int id, Genre genre) {
        if (!repo.existsById(id))
            throw new NoSuchElementException("Genre with id " + id + " does not exist");
        genre.setId(id); 
        repo.save(genre);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
}