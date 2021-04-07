package com.amazon.bookstore;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class BookStore {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;



    public BookStore(){
        this.books = new ArrayList<Book>();
    }
    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }


    public List<Book> getBooks(){ return this.books; }
    public void setBooks(List<Book> books){ this.books = books; }


    public boolean addBook(Book b){
        //b.setBookstore(this);
        return books.add(b);
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }


    public boolean removeBook(Book b){
        return books.remove(b);
    }


}
