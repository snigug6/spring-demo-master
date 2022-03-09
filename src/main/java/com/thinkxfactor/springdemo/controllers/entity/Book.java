package com.thinkxfactor.springdemo.controllers.entity;

public class Book {
    //String name
    //String ISBN
    //String description

    private String name;
    private String isbn;
    private String description;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
