package com.amazon.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookstoreController {

    @GetMapping("/")
    public String index(Model model) {
        Book b1 = new Book("Harry Potter", "JK Rowling", "N/A", 123, "HP", "Fantasy");
        Book b2 = new Book("Lord of the Rings", "JRR Tolkien", "N/A", 124, "LOTR", "Fantasy");
        BookStore books = new BookStore();
        books.addBook(b1);
        books.addBook(b2);

        model.addAttribute("bookstore", books);

        return "bookstore";
    }

}
