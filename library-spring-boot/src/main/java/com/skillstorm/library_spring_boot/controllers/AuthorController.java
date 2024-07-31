package com.skillstorm.library_spring_boot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.library_spring_boot.models.Author;
import com.skillstorm.library_spring_boot.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorRepository repo;

    public AuthorController(AuthorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Author getMethodName(@PathVariable int id) {
        return repo.findById(id).get();
    }
}
