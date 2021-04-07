package com.amazon.bookstore;

import static javax.persistence.CascadeType.ALL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany( cascade=ALL)
    private List<Book> books;

    //Constructor
    public ShoppingCart(){
        this.books = new ArrayList<Book>();
    }


    public Long getId(){ return this.id; }
    public void setId(Long id){ this.id = id; }


    public List<Book> getBooks() { return this.books; }
    public void setBooks(List<Book> books) { this.books = books; }
    public void addBook(Book book){
        this.books.add(book);
    }


}
