package com.amazon.bookstore;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShoppingCartTest {

   /* Book book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3, "https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
    BookStore bookStore = new BookStore("Haven");
    List<ShoppingCart> listBook = new ArrayList<ShoppingCart>();
    ShoppingCart shoppingCart = new ShoppingCart();
    List<Book> books = new ArrayList<Book>();
    User user = new User("Emma");

   /**
        if(user.getShoppingCart() == null)
    {
        List<Book> newCart = new ArrayList<Book>();
        user.setShoppingCart(newCart);
    }

        if(!user.getShoppingCart().contains(book))
    {
        user.addToCart(book);
        userRepo.save(user);
    }

        model.addAttribute("userID", uid);
        model.addAttribute("books", user.getShoppingCart());**/
    /*
    @Test
    public void testGetBooks() {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3);
        user.addToCart(book1);
        shoppingCart.addBook(book1);
        shoppingCart.getBooks();
        assertEquals(user.getShoppingCart(), shoppingCart.getBooks());
    }

   @Test
    public void testSetBooks() {

        user.setShoppingCart(books);
        shoppingCart.setBooks(books);
        assertEquals(user.getShoppingCart(), shoppingCart.getBooks());
    }

    @Test
    public void testAddBook(){
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061, "pursue your dreams by following what your heart desires", "Adventure",3);
        Book book2 = new Book("xyz", "Paulo Coelho", "HarperCollins", 9784661, "ewtwqq", "Adventure",3);
        user.addToCart(book1);
        user.addToCart(book2);
        shoppingCart.addBook(book1);
        shoppingCart.addBook(book2);
        assertEquals(shoppingCart.getBooks(), user.getShoppingCart());
    }

    */

}

