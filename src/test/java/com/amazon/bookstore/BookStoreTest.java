package com.amazon.bookstore;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookStoreTest {

    Book book1 = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure");
    BookStore bookStore = new BookStore("Haven");
    List<Book> listBook = new ArrayList<>();

    @Test
    void getBooks() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    void setBooks() {
        listBook.add(book1);
        bookStore.setBooks(listBook);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    void addBook() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    void getName() {
        assertEquals(bookStore.getName(), "Haven");
    }

    @Test
    void setName() {
        bookStore.setName("Carleton");
        assertEquals(bookStore.getName(), "Carleton");
    }

    @Test
    void removeBook() {
        bookStore.addBook(book1);
        bookStore.removeBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }
}