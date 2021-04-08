package com.amazon.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;


@Controller
public class RecommendationsControllers {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;

    JaccardDistance jd;

    @PostMapping("/recommendation")
    public String recommendation(Model model, @ModelAttribute("userID") String uid) {

        jd = new JaccardDistance();
        User user = userRepo.findByName(uid);
        HashSet<Book> recommendedBooks = new HashSet<Book>();
        ArrayList<Book> recommendedAndAvailableBooks = new ArrayList<Book>();


        ArrayList<User> userArrayList = new ArrayList<User>();
        Iterable<User> users = userRepo.findAll();
        for (User u : users){
            userArrayList.add(u);
        }

        recommendedBooks.addAll(jd.getRecommendation(user, userArrayList, 4));
        Iterable<Book> availableBooks = bookRepo.findAll();

        for (Book recommendedBook : recommendedBooks){
            for (Book availableBook : availableBooks){
                if (recommendedBook.equals(availableBook)){
                    recommendedAndAvailableBooks.add(availableBook);
                    break;
                }
            }
        }

        model.addAttribute("recommendBook", recommendedAndAvailableBooks);

        return "recommendation";
    }



}

