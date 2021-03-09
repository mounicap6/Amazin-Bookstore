package com.amazon.bookstore;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class BookStore {

    private Long id;

    private String name;

    ArrayList<Book> books;

    public BookStore(){
        this.books = new ArrayList<Book>();
    }
    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    @OneToMany(mappedBy = "bookstore")
    public ArrayList<Book> getBooks(){ return this.books; }
    public void setBooks(ArrayList<Book> books){ this.books = books; }


    public boolean addBook(Book b){
        b.setBookstore(this);
        return books.add(b);
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }


    public boolean removeBook(Book b){
        return books.remove(b);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
