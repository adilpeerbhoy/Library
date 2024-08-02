package com.skillstorm.library_spring_boot.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.library_spring_boot.models.Library;
import com.skillstorm.library_spring_boot.services.LibraryService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
    
    private LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }
    
    @GetMapping
    public Iterable<Library> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Library> findById(@PathVariable int id) {
        Optional<Library> library = service.findById(id);
        if (library.isPresent())
            return ResponseEntity.ok(library.get());
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public Library createLibrary(@Valid @RequestBody Library library) {
        return service.save(library);
    }
    
    @PutMapping("/{id}")
    public Library update(@PathVariable int id, @RequestBody Library library) {
        service.update(id, library);
        return library;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}
