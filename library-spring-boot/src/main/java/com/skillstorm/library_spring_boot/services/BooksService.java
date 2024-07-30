package com.skillstorm.library_spring_boot.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.library_spring_boot.models.Books;
import com.skillstorm.library_spring_boot.repositories.BooksRepository;

@Service
public class BooksService {

    private BooksRepository repo;

    // Use dependency injection to get an instance of the BooksRepository
    public BooksService(BooksRepository repo) {
        this.repo = repo;
    }

    public Iterable<Books> findAll() {
        return repo.findAll();
    }

    public Optional<Books> findByBarcode(int barcode) {
        return repo.findByBarcode(barcode);
    }


    public Books save(Books books) {
        return repo.save(books);
    }

    public void update (int barcode, Books books) {
        if (!repo.existsById(barcode))
            throw new NoSuchElementException("Book with barcode " + barcode + " does not exist");
        books.setBarcode(barcode); // ERROR - the method setBarcode(int) is undefined for the type Books
        repo.save(books);
    }

    public void deleteByBarcode(int barcode) {
        repo.deleteByBarcode(barcode);
    }
    
}
