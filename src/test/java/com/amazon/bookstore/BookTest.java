package com.amazon.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookTest {

    Book book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3);

    @Test
    public void testGetIsbn() {
        assertEquals(this.book.getIsbn(), 9780061);
    }

    @Test
    public void testSetIsbn() {
        book.setIsbn(1234567);
        assertEquals(this.book.getIsbn(), 1234567);
    }

    @Test
    public void testGetTitle() {
        assertEquals(this.book.getTitle(), "The Alchemist");
    }

    @Test
    public void testSetTitle() {
        book.setTitle("Nowhere");
        assertEquals(this.book.getTitle(), "Nowhere");
    }

    @Test
    public void testGetDescription() {
        assertEquals(this.book.getDescription(), "pursue your dreams by following what your heart desires");
    }

    @Test
    public void testSetDescription() {
        book.setDescription("Going nowhere and trying nothing");
        assertEquals(this.book.getDescription(), "Going nowhere and trying nothing");
    }

    @Test
    public void testGetAuthor() {
        assertEquals(this.book.getAuthor(), "Paulo Coelho");
    }

    @Test
    public void testSetAuthor() {
        book.setAuthor("Lynn");
        assertEquals(this.book.getAuthor(), "Lynn");
    }

    @Test
    public void testGetPublisher() {
        assertEquals(this.book.getPublisher(), "HarperCollins");
    }

    @Test
    public void testSetPublisher() {
        book.setPublisher("Berain");
        assertEquals(this.book.getPublisher(), "Berain");
    }

    @Test
    public void testGetGenre() {
        assertEquals(this.book.getGenre(), "Adventure");
    }

    @Test
    public void testSetGenre() {
        book.setGenre("Fiction");
        assertEquals(this.book.getGenre(), "Fiction");
    }

    @Test
    public void testGetQuantity(){ assertEquals(this.book.getQuantity(), 3);}

    @Test
    public void testSetQuantity(){
        book.setQuantity(1);
        assertEquals(this.book.getQuantity(), 1);
    }
}
