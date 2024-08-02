package com.skillstorm.library_spring_boot.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.library_spring_boot.models.Author;
import com.skillstorm.library_spring_boot.models.Books;
import com.skillstorm.library_spring_boot.models.Genre;
import com.skillstorm.library_spring_boot.repositories.BooksRepository;
import com.skillstorm.library_spring_boot.repositories.GenreRepository;
import com.skillstorm.library_spring_boot.repositories.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class BooksService {

    private BooksRepository repo;

    private AuthorRepository authorRepo;

    private GenreRepository genreRepo;

    // Use dependency injection to get an instance of the BooksRepository
    public BooksService(BooksRepository repo, AuthorRepository authorRepo, GenreRepository genreRepo) {
        this.repo = repo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
    }

    public Iterable<Books> findAll() {
        return repo.findAll();
    }

    public Optional<Books> findByBarcode(int barcode) {
        return repo.findByBarcode(barcode);
    }

    // Original Save Method to books repository
    // public Books save(Books books) {
    //     return repo.save(books);
    // }

    @Transactional
    public Books save(Books books) {
        Author author = books.getAuthor();
        if (authorRepo.existsById(author.getId())) {
            Author existingAuthor = authorRepo.findById(author.getId()).get();
            books.setAuthor(existingAuthor);}

        Genre wantedGenre = books.getGenre();
        if (genreRepo.existsById(wantedGenre.getId())) {
            Genre existingGenre = genreRepo.findById(wantedGenre.getId()).get();
            books.setGenre(existingGenre);}
        
    return repo.save(books);
        }

    public void update (int barcode, Books books) {
        if (!repo.existsById(barcode))
            throw new NoSuchElementException("Book with barcode " + barcode + " does not exist");
        books.setBarcode(barcode);
        repo.save(books);
    }

    public void updateTitle (Books books, String title) {
        books.setTitle(title);
        repo.save(books);
    }

    public void deleteByBarcode(int barcode) {
        repo.deleteByBarcode(barcode);
    }

    // public void createBooks(Books books) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createBooks'");
    // }

    // public List<Books> getBooksByLibraryId(int id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getBooksByLibraryId'");
    // }
    
}
