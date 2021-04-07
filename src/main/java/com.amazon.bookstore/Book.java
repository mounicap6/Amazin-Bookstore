package com.amazon.bookstore;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.persistence.*;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int isbn, quantity;
    private String title, description, author, publisher, genre, picture;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<ShoppingCart> shoppingCarts;

    public Book(String title, String author, String publisher, int isbn, String description, String genre, int quantity, String picture){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.genre = genre;
        this.quantity = quantity;
        this.shoppingCarts = new ArrayList<ShoppingCart>();
        this.picture = picture;
    }

    public Book()
    {

    }


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Set the shopping cart for this book
    public List<ShoppingCart> getShoppingCarts(){ return this.shoppingCarts; }
    public void setShoppingCarts(List<ShoppingCart> shoppingCarts){ this.shoppingCarts = shoppingCarts; }
    public void addShoppingCart(ShoppingCart shoppingCart){this.shoppingCarts.add(shoppingCart);}
    public void removeShoppingCart(ShoppingCart shoppingCart){this.shoppingCarts.remove(shoppingCart);}
    public void removeShoppingCarts(){
        this.shoppingCarts = new ArrayList<ShoppingCart>();;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
