package com.skillstorm.library_spring_boot.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Map library table and column names in DB
// Library contains ID, Branch Name, Street Address, City, and State
@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String street;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String state;

// Create a One to Many relationship with the Books class
// Allows the library to contain multiple books
@OneToMany(mappedBy = "library", targetEntity = Books.class)
@JsonManagedReference
private List<Books> books;

public void setBooks(List<Books> books) {
    this.books = books;
}

public List<Books> getBooks() {
    return books;
}

public Library(){}

public Library (int id, String name, String street, String city, String state) {
    this.id = id;
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getStreet() {
    return street;
}

public void setStreet(String street) {
    this.street = street;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public String getState() {
    return state;
}

public void setState(String state) {
    this.state = state;
}

@Override
public String toString() {
    return "Library [id=" + id + ", name=" + name + ", street=" + street + ", city=" + city + ", state=" + state + "]";
}



// public void setBooks(Books existingBooks) {
//     // TODO Auto-generated method stub
//     throw new UnsupportedOperationException("Unimplemented method 'setBooks'");
// }



}
