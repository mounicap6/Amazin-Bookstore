package com.amazon.bookstore;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
       model.addAttribute("allBooks", books);
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


    @PostMapping("/search")
    public String searchForBook(@RequestParam(name="keyword") String keyword,
                                @RequestParam(name="category") String category, Model model){
        BookStore searchedBooks = new BookStore();
        switch(category){
            case "Title":
                for(Book b : bookRepo.findByTitle(keyword)){
                    searchedBooks.addBook(b);
                }
                break;
            case "Author":
                for(Book b : bookRepo.findByAuthor(keyword)){
                    searchedBooks.addBook(b);
                }
                break;
            case "Publisher":
                for(Book b : bookRepo.findByPublisher(keyword)){
                    searchedBooks.addBook(b);
                }
                break;

            case "ISBN":
                if (!keyword.matches("[0-9]+")) {
                    break;
                }
                int isbn = Integer.parseInt(keyword);
                for(Book b : bookRepo.findByIsbn(isbn)){
                    searchedBooks.addBook(b);
                }
                break;
            case "Description":
                for(Book b : bookRepo.findByDescription(keyword)){
                    searchedBooks.addBook(b);
                }
                break;
            case "Genre":
                for(Book b : bookRepo.findByGenre(keyword)){
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
