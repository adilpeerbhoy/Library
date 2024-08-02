package com.skillstorm.library_spring_boot.models;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@NamedEntityGraph(
    name = "Books.withAuthor",
    attributeNodes = @NamedAttributeNode("author")
)
@Table(name = "books")
public class Books {

    // Map the columns from the books table - Barcode, Title, and Status
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int barcode;

    @Column(length = 50)
    private String title;

    @Column
    private String status;

    // Join Author and Genre table columns - Author First and Last Name, Genre
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "author_id")
    @JsonIdentityReference(alwaysAsId=true)
    //@JsonManagedReference
    private Author author;

    // @JsonProperty("author")
    // public String getAuthorName() {
    //     return author.getFirstName() + " " + author.getLastName();
    // }

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "genre_id")
    @JsonIdentityReference(alwaysAsId=true)
    private Genre genre;

    // @JsonProperty("genre")
    // public String getGenre() {
    //     return genre.getGenre();
    // }

    // Update
    // Mapping books with a library
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "library_id")
    //@JsonIdentityReference(alwaysAsId=true)
    @JsonBackReference
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Books> getBooks(List<Books> books) {
        return books;
    }
    
    public void setBooks(List<Books> books) {
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
         return genre;
     }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Books [barcode=" + barcode + ", title=" + title + ", status=" + status + ", author=" + author
                + ", genre=" + genre + ", library=" + library + "]";
    }

    
    // @Override
    // public String toString() {
    //     return "Books [barcode=" + barcode + ", title=" + title + ", status=" + status + "]";
    // }

}
