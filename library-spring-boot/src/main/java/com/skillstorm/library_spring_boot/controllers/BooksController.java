package com.skillstorm.library_spring_boot.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.skillstorm.library_spring_boot.models.Books;
import com.skillstorm.library_spring_boot.services.BooksService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
public class BooksController {
    
    private BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Books> findAll() {
        return service.findAll();
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<Books> findByBarcode(@PathVariable int barcode) {
        Optional<Books> books = service.findByBarcode(barcode);
        if (books.isPresent())
            return ResponseEntity.ok(books.get());
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   
    
    }
    

