package com.amazon.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class BookstoreController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/")
    public String index(Model model) {
        Book b1 = new Book("Harry Potter", "JK Rowling", "N/A", 123, "HP", "Fantasy", 1);
        Book b2 = new Book("Lord of the Rings", "JRR Tolkien", "N/A", 124, "LOTR", "Fantasy", 2);
        BookStore books = new BookStore();
        books.addBook(b1);
        books.addBook(b2);

        model.addAttribute("bookstore", books);

        return "bookstore";
    }
    @GetMapping("/")
    public String index(Model model) {
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "bookstore";
    }

    @PostMapping("/editBookstore")
    public String uploadBookstore(){

        return "editBookstore";
    }

    @PostMapping("/uploadBook")
    @ResponseBody
    public Book createBook(Book book){
        Book b = bookRepo.save(book);
        return b;
    }

}
