package com.amazon.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;

public class RecommendationsController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private JaccardDistance jd;

    @GetMapping("/getBookRecommendations/{name}")
    public ArrayList<Book> getBookRecommendation(@PathVariable String name) {
        User user = userRepo.findByName(name);
        HashSet<Book> recommendedBooks = new HashSet<Book>();
        ArrayList<Book> recommendedAndAvailableBooks = new ArrayList<Book>();

        if (user.getPurchasedBooks().isEmpty()){
            return recommendedAndAvailableBooks;
        }

        ArrayList<User> userArrayList = new ArrayList<User>();
        Iterable<User> users = userRepo.findAll();
        for (User u : users){
            userArrayList.add(u);
        }

        recommendedBooks.addAll(jd.getRecommendation(user, userArrayList, 1)); // one recommendation
        Iterable<Book> availableBooks = bookRepo.findAll();

        for (Book recommendedBook : recommendedBooks){
            for (Book availableBook : availableBooks){
                if (recommendedBook.equals(availableBook)){
                    recommendedAndAvailableBooks.add(availableBook);
                    break;
                }
            }
        }

        return recommendedAndAvailableBooks;
    }

}

