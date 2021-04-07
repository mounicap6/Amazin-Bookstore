package com.amazon.bookstore;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookStoreTest{

    Book book1 = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure", 3);
    BookStore bookStore = new BookStore("Haven");
    List<Book> listBook = new ArrayList<>();

    @Test
    public void testGetBooks() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    public void testSetBooks() {
        listBook.add(book1);
        bookStore.setBooks(listBook);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    public void testAddBook() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    @Test
    public void testGetName() {
        assertEquals(bookStore.getName(), "Haven");
    }

    @Test
    public void testSetName() {
        bookStore.setName("Carleton");
        assertEquals(bookStore.getName(), "Carleton");
    }

    @Test
    public void testRemoveBook() {
        bookStore.addBook(book1);
        bookStore.removeBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }
}