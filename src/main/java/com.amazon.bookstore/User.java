package com.amazon.bookstore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    private String name;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> shoppingCart;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> purchasedBooks;

    public User(String name){
        this.name = name;
        shoppingCart = new ArrayList<Book>();
        purchasedBooks = new ArrayList<>();
    }

    public User() {
        shoppingCart = new ArrayList<Book>();
        purchasedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Book> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Book> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(Book book){ shoppingCart.add(book);}

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(ArrayList<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }
}
