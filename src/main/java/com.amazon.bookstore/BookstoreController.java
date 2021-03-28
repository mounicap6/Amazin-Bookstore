package com.amazon.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@Controller
public class BookstoreController {

    @Autowired
    BookRepo bookRepo;

   @GetMapping("/user_homepage")
    public String userHomepage(Model model) {
       BookStore books = new BookStore();
       for(Book b : bookRepo.findAll()){
           books.addBook(b);
       }
       model.addAttribute("bookstore", books);

       return "userBookstore";
    }

    @GetMapping("/owner_homepage")
    public String ownerHomepage(Model model) {
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "ownerBookstore";
    }

    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @PostMapping("/bookstore")
    public String mainpage(Model model) {
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "ownerBookstore";
    }

    @PostMapping("/editBookstore")
    public String uploadBookstore(){
        //functionality here
        return "editBookstore";
    }

    @PostMapping("/uploadBook")
    public String createBook(Book book){
        bookRepo.save(book);
        return "editBookstore";
    }

    @PostMapping("/shoppingcart")
    public String addToCart(Book book, Model model)
    {

        ArrayList<Book> cartContents = new ArrayList<Book>();
        BookStore books = new BookStore();
        books.setShoppingCart(cartContents);
        books.addToCart(book);
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }

        model.addAttribute("bookstore", books);
        return "userBookstore";
    }


}
