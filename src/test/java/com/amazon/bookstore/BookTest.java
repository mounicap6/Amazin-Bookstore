package com.amazon.bookstore;

import junit.framework.TestCase;

public class BookTest extends TestCase {

    Book book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3);

    public void testGetIsbn() {
        assertEquals(this.book.getIsbn(), 9780061);
    }

    public void testSetIsbn() {
        book.setIsbn(1234567);
        assertEquals(this.book.getIsbn(), 1234567);
    }

    public void testGetTitle() {
        assertEquals(this.book.getTitle(), "The Alchemist");
    }

    public void testSetTitle() {
        book.setTitle("Nowhere");
        assertEquals(this.book.getTitle(), "Nowhere");
    }

    public void testGetDescription() {
        assertEquals(this.book.getDescription(), "pursue your dreams by following what your heart desires");
    }

    public void testSetDescription() {
        book.setDescription("Going nowhere and trying nothing");
        assertEquals(this.book.getDescription(), "Going nowhere and trying nothing");
    }

    public void testGetAuthor() {
        assertEquals(this.book.getAuthor(), "Paulo Coelho");
    }

    public void testSetAuthor() {
        book.setAuthor("Lynn");
        assertEquals(this.book.getAuthor(), "Lynn");
    }

    public void testGetPublisher() {
        assertEquals(this.book.getPublisher(), "HarperCollins");
    }

    public void testSetPublisher() {
        book.setPublisher("Berain");
        assertEquals(this.book.getPublisher(), "Berain");
    }

    public void testGetGenre() {
        assertEquals(this.book.getGenre(), "Adventure");
    }

    public void testSetGenre() {
        book.setGenre("Fiction");
        assertEquals(this.book.getGenre(), "Fiction");
    }

    public void testGetQuantity(){ assertEquals(this.book.getQuantity(), 3);}

    public void testSetQuantity(){
        book.setQuantity(1);
        assertEquals(this.book.getQuantity(), 1);
    }
}
