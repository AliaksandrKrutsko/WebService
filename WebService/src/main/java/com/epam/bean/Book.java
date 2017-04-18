package com.epam.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Book implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("author")
    private String author;
    @JsonProperty("isbn")
    private int isbn;

    public Book() {
    }

    public Book(String name, String author, int isbn) {
        this.name=name;
        this.author=author;
        this.isbn=isbn;
    }

    public void setName(String name) {this.name=name;}
    public void setAuthor(String author) {this.author=author;}
    public void setIsbn(int isbn) {this.isbn=isbn;}
    public String getName() {return name;}
    public String getAuthor() {return author;}
    public int getIsbn() {return isbn;}

    public String toString() {
        return "author: " + this.author + ", " + "name: " + this.name + ", " + "isbn: "
                + this.isbn;
    }
}
