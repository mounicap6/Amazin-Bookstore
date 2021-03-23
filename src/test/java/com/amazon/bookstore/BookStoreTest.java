package com.amazon.bookstore;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class BookStoreTest extends TestCase {

    Book book1 = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure", 3);
    BookStore bookStore = new BookStore("Haven");
    List<Book> listBook = new ArrayList<>();

    public void testGetBooks() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    public void testSetBooks() {
        listBook.add(book1);
        bookStore.setBooks(listBook);
        assertEquals(bookStore.getBooks(), listBook);
    }

    public void testAddBook() {
        listBook.add(book1);
        bookStore.addBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }

    public void testGetName() {
        assertEquals(bookStore.getName(), "Haven");
    }

    public void testSetName() {
        bookStore.setName("Carleton");
        assertEquals(bookStore.getName(), "Carleton");
    }

    public void testRemoveBook() {
        bookStore.addBook(book1);
        bookStore.removeBook(book1);
        assertEquals(bookStore.getBooks(), listBook);
    }
}