package com.amazon.bookstore;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    User user = new User("George");
    ShoppingCart shoppingCart = new ShoppingCart();
    Book book = new Book("The Alchemist", "Paulo Coelho", "HarperCollins", 9780061,
            "pursue your dreams by following what your heart desires", "Adventure", 3,
            "https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
    ArrayList books = new ArrayList();


    @Test
    public void getName() {
        assert(user.getName().equals("George"));
    }

    @Test
    public void setName() {
        user.setName("Bob");
        assert(user.getName().equals("Bob"));
    }

    @Test
    public void getShoppingCart() {
        assert(user.getShoppingCart() != null);
    }

    @Test
    public void setShoppingCart() {
        user.setShoppingCart(shoppingCart.getBooks());
        assertEquals(user.getShoppingCart(), shoppingCart.getBooks());
    }

    @Test
    public void addToCart() {
        user.addToCart(book);
        assert(user.getShoppingCart().size() == 1);
        assert(user.getShoppingCart().contains(book));
    }

    @Test
    public void getPurchasedBooks() {
        assert(user.getPurchasedBooks() != null);
    }

    @Test
    public void setPurchasedBooks() {
        books.add(book);
        user.setPurchasedBooks(books);
        assert(user.getPurchasedBooks().size() == 1);
        assert(user.getPurchasedBooks().contains(book));
    }
}