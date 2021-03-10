package com.amazon.bookstore;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getIsbn() {
        assertEquals(this.book.getIsbn(), 9780061);
    }

    @org.junit.jupiter.api.Test
    void setIsbn() {
        book.setIsbn(1234567);
        assertEquals(this.book.getIsbn(), 1234567);
    }

    @org.junit.jupiter.api.Test
    void getTitle() {
        assertEquals(this.book.getTitle(), "The Alchemist");
    }

    @org.junit.jupiter.api.Test
    void setTitle() {
        book.setTitle("Nowhere");
        assertEquals(this.book.getTitle(), "Nowhere");
    }

    @org.junit.jupiter.api.Test
    void getDescription() {
        assertEquals(this.book.getDescription(), "pursue your dreams by following what your heart desires");
    }

    @org.junit.jupiter.api.Test
    void setDescription() {
        book.setDescription("Going nowhere and trying nothing");
        assertEquals(this.book.getDescription(), "Going nowhere and trying nothing");
    }

    @org.junit.jupiter.api.Test
    void getAuthor() {
        assertEquals(this.book.getAuthor(), "Paulo Coelho");
    }

    @org.junit.jupiter.api.Test
    void setAuthor() {
        book.setAuthor("Lynn");
        assertEquals(this.book.getAuthor(), "Lynn");
    }

    @org.junit.jupiter.api.Test
    void getPublisher() {
        assertEquals(this.book.getPublisher(), "HarperCollins");
    }

    @org.junit.jupiter.api.Test
    void setPublisher() {
        book.setPublisher("Berain");
        assertEquals(this.book.getPublisher(), "Berain");
    }

    @org.junit.jupiter.api.Test
    void getGenre() {
        assertEquals(this.book.getGenre(), "Adventure");
    }

    @org.junit.jupiter.api.Test
    void setGenre() {
        book.setGenre("Fiction");
        assertEquals(this.book.getGenre(), "Fiction");
    }

    @org.junit.jupiter.api.Test
    void getImage() {
    }

    @org.junit.jupiter.api.Test
    void setImage() {
    }
}