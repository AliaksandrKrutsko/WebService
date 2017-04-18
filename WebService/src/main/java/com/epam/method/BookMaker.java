package com.epam.method;

import com.epam.bean.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMaker {

    private List<Book> books;

    public BookMaker() {
        books.add(new Book("name", "author", 1111));
        books.add(new Book("Lord of the Rings", "J.R.R.Tolkien", 2222));
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public List<Book> getBooks() {return books;}

    public static List<Book> getAllBook() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("name", "author", 1111));
        books.add(new Book("Lord of the Rings", "J.R.R.Tolkien", 2222));
        return books;
    }
}
