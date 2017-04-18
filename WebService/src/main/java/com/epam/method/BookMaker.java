package com.epam.method;

import com.epam.bean.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMaker {

    public static Book getBook(int id) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("name", "author", 1111));
        books.add(new Book("Lord of the Rings", "J.R.R.Tolkien", 2222));
        return books.get(id);
    }

    //public List<Book> getBooks() {return books;}

}
