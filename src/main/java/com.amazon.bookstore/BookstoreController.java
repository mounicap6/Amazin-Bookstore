package com.amazon.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookstoreController {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;

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

    @PostMapping("/addOrGetUser")
    public String addOrGetUser(@RequestParam String name, Model model){
       if(name.equals("")){
           return "homepage";
       } else{
           User user = userRepo.findByName(name);
           //Username already exists
           if(user != null){
                //pull info required from current user (shopping cart/purchase history)
           }
           //Username doesn't exist so create a new user
           else{
               User newUser = new User(name);
               userRepo.save(newUser);
           }

           BookStore books = new BookStore();
           for(Book b : bookRepo.findAll()){
               books.addBook(b);
           }
           model.addAttribute("bookstore", books);
           return "userBookstore";
       }

    }


}
