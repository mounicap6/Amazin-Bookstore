package com.amazon.bookstore;
import java.awt.image.BufferedImage;
import javax.persistence.*;


@Entity
public class Book {

    private Long id;
    private int isbn;
    private String title, description, author, publisher, genre;
    private BufferedImage image;

    private BookStore bookstore;

    public Book(String title, String author, String publisher, int isbn, String description, String genre){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.genre = genre;
    }

    public Book()
    {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    public BookStore getBookstore(){ return this.bookstore; }
    public void setBookstore(BookStore bookstore){ this.bookstore = bookstore; }
    public void removeBookstore(){this.bookstore = null;}

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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
