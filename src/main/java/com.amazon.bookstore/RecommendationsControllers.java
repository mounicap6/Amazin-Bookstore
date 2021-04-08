package com.amazon.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class RecommendationsControllers {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;

    @PostMapping("/recommendation")
    public String recommendation(Model model, @ModelAttribute("userID") String uid) {

        User user = userRepo.findByName(uid);
        String genre = user.getPurchasedBooks().get(0).getGenre();

        BookStore recommendBook = new BookStore();
        for (Book b : bookRepo.findAll()) {
            if(genre.equals(b.getGenre()) && !(b.equals(user.getPurchasedBooks().get(0)))) {
                recommendBook.addBook(b);
            }
        }

        model.addAttribute("recommendBook", recommendBook);

        return "recommendation";
    }

}

