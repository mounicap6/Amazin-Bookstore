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
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "bookstore";
    }

    @PostMapping("/editBookstore")
    public String uploadBookstore(){
        //functionality here
        return "editBookstore";
    }

    @PostMapping("/uploadBook")
    public String createBook(Book book){
        bookRepo.save(book);
        return "bookstore";
    }

}
