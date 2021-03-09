package com.amazon.bookstore;

import java.util.ArrayList;

public class BookStore {

    ArrayList<Book> books;

    public BookStore(){
        books = new ArrayList<>();
    }

    public boolean addBook(Book b){
        return books.add(b);
    }

    public boolean removeBook(Book b){
        return books.remove(b);
    }
}
