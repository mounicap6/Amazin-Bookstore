package com.amazon.bookstore;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest extends TestCase  {

    Book book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3);
    BookStore bookStore = new BookStore("Haven");
    List<ShoppingCart> listBook = new ArrayList<ShoppingCart>();
    ShoppingCart shoppingCart = new ShoppingCart();
    List<Book> books = new ArrayList<Book>();

    public void testGetBooks() {
        book.addShoppingCart(shoppingCart);
        listBook.add(shoppingCart);
        assertEquals(book.getShoppingCarts(), listBook);
    }

    public void testSetBooks() {
        book.addShoppingCart(shoppingCart);
        listBook.add(shoppingCart);
        shoppingCart.setBooks(books);
        assertEquals(book.getShoppingCarts(), listBook);
    }

    public void testAddBook(){
        books.add(book);
        shoppingCart.addBook(book);
        assertEquals(shoppingCart.getBooks(), books);
    }

    public void testRemoveBook(){
        shoppingCart.addBook(book);
        shoppingCart.removeBook(book);
        assertEquals(shoppingCart.getBooks(), books);
    }
}

