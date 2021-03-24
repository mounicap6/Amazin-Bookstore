package com.amazon.bookstore;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


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

       return "bookstore";
    }

    @GetMapping("/owner_homepage")
    public String ownerHomepage(Model model) {
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "bookstore";
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
        return "editBookstore";
    }

    @GetMapping("/{bookId}/editBook")
    public String showEditBook(Model model, @PathVariable long bookId){
        Book book = null;
        try{
            book = bookRepo.findById(bookId);
        }
        catch (ResourceNotFoundException ex){
            model.addAttribute("error","Book not found");
        }
        model.addAttribute("book", book);
        return "book-edit";

    }


    @PostMapping("/{bookId}/editBook")
    public String editBook(Model model, @PathVariable long bookId, @ModelAttribute("book") Book book){
        book.setId(bookId);
        bookRepo.save(book);
        return String.valueOf(book.getId());
    }


    @PostMapping("/shoppingcart")
    public String addToCart(Book book, Model model)
    {
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);
        return "bookstore";
    }


}
