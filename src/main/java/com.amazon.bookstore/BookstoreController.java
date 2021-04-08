package com.amazon.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Controller
public class BookstoreController {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("/user_homepage")
    public String userHomepage(@ModelAttribute("userID") String uid, Model model) {
        User user = userRepo.findByName(uid);
        BookStore books = new BookStore();
        for (Book b : bookRepo.findAll()) {
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);
        model.addAttribute("userID", uid);

        return "userBookstore";
    }

    @GetMapping("/owner_homepage")
    public String ownerHomepage(Model model) {
        BookStore books = new BookStore();
        for (Book b : bookRepo.findAll()) {
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "ownerBookstore";
    }

    @GetMapping("/")
    public String homePage() {
        return "homepage";
    }

    @PostMapping("/bookstore")
    public String mainpage(Model model) {

        BookStore books = new BookStore();
        for (Book b : bookRepo.findAll()) {
            books.addBook(b);
        }

        model.addAttribute("bookstore", books);
        return "ownerBookstore";
    }

    @PostMapping("/editBookstore")
    public String uploadBookstore() {
        //functionality here
        return "editBookstore";
    }

    @PostMapping("/uploadBook")
    public String createBook(Book book) {
        bookRepo.save(book);
        return "editBookstore";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("userID") String uid,  Model model)
    {
        User user = userRepo.findByName(uid);

        //nothing in the cart..
        if(user.getShoppingCart() == null) {
            return "userBookstore";
        }

        if(user.getPurchasedBooks() == null)
        {
            ArrayList<Book> purchases = new ArrayList<Book>();
            user.setPurchasedBooks(purchases);
        }

        for(Book b: user.getShoppingCart())
        {
            user.getPurchasedBooks().add(b);
            int oldInventory = b.getQuantity();
            b.setQuantity(oldInventory - 1);
        }

        userRepo.save(user);
        model.addAttribute("userID", uid);
        model.addAttribute("purchase", user.getShoppingCart());

        return "checkout";
    }

    @PostMapping("/shoppingcart")
    public String addToCart(@ModelAttribute("userID") String uid, Book book, Model model) {

        User user = userRepo.findByName(uid);

        if(user.getShoppingCart() == null)
        {
            List<Book> newCart = new ArrayList<Book>();
            user.setShoppingCart(newCart);
        }

        if(!user.getShoppingCart().contains(book))
        {
            user.addToCart(book);
            userRepo.save(user);
        }

        model.addAttribute("userID", uid);
        model.addAttribute("books", user.getShoppingCart());


        return "shoppingcart";
    }

    @PostMapping("/addOrGetUser")
    public String addOrGetUser(@RequestParam String name, Model model) {

        User user;
        if (name.equals("")) {
            return "homepage";
        } else {
            user = userRepo.findByName(name);
            //Username already exists
            if (user != null) {
                //pull info required from current user (shopping cart/purchase history)
            }
            //Username doesn't exist so create a new user
            else {
                user = new User(name);
                userRepo.save(user);
            }

            BookStore books = new BookStore();
            for (Book b : bookRepo.findAll()) {
                books.addBook(b);
            }
            model.addAttribute("bookstore", books);
            model.addAttribute("userID", user.getName());
            return "userBookstore";
        }
    }

    @PostMapping("/search")
    public String searchForBook(@RequestParam(name = "keyword") String keyword,
                                @RequestParam(name = "category") String category, Model model) {

        BookStore searchedBooks = new BookStore();
        switch (category) {
            case "Title":
                for (Book b : bookRepo.findByTitle(keyword)) {
                    searchedBooks.addBook(b);
                }
                break;
            case "Author":
                for (Book b : bookRepo.findByAuthor(keyword)) {
                    searchedBooks.addBook(b);
                }
                break;
            case "Publisher":
                for (Book b : bookRepo.findByPublisher(keyword)) {
                    searchedBooks.addBook(b);
                }
                break;

            case "ISBN":
                if (!keyword.matches("[0-9]+")) {
                    break;
                }
                int isbn = Integer.parseInt(keyword);
                for (Book b : bookRepo.findByIsbn(isbn)) {
                    searchedBooks.addBook(b);
                }
                break;
            case "Description":
                for (Book b : bookRepo.findByDescription(keyword)) {
                    searchedBooks.addBook(b);
                }
                break;
            case "Genre":
                for (Book b : bookRepo.findByGenre(keyword)) {
                    searchedBooks.addBook(b);
                }
                break;
        }
        model.addAttribute("bookstore", searchedBooks);

        return "userBookstore";
    }

    @RequestMapping(value= "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("isbn")  int isbn, Model model){
        for(Book book : bookRepo.findByIsbn(isbn)) {
            bookRepo.delete(book);
        }
        BookStore books = new BookStore();
        for(Book b : bookRepo.findAll()){
            books.addBook(b);
        }
        model.addAttribute("bookstore", books);

        return "ownerBookstore";
    }





}
