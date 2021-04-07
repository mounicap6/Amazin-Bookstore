package com.amazon.bookstore;

import java.util.*;
import java.util.stream.Collectors;

public class JaccardDistance {
    public Double getDistance(User u1, User u2){
        Double distance = 0.0;

        List<Book> u1Books = u1.getPurchasedBooks();
        List<Book> u2Books = u2.getPurchasedBooks();
        HashSet<Book> allBooks = new HashSet<Book>();

        Set<Book> sharedBooks = u1Books.stream()
                .distinct()
                .filter(u2Books::contains)
                .collect(Collectors.toSet());

        allBooks.addAll(u1Books);
        allBooks.addAll(u2Books);

        distance = ((double)sharedBooks.size() / (double)allBooks.size()) * 100;
        return (100.00 - Math.round(distance*100.0)/100.0);
    }

    public HashSet<Book> getRecommendation(User user, ArrayList<User> users, Integer range){
        HashSet<Book> bookRecommendations = new HashSet<Book>();

        List<Book> boughtBooks = user.getPurchasedBooks();

        if (boughtBooks.isEmpty()){
            return bookRecommendations;
        }

        ArrayList<User> closeUsers = findClosestUsers(user, users, range);

        //recommend books they haven't bought yet
        for (User closeUser : closeUsers){
            List<Book> closeUserPurchasedBooks = closeUser.getPurchasedBooks();
            for (Book book : closeUserPurchasedBooks){
                if (!boughtBooks.contains(book)){
                    bookRecommendations.add(book);
                }
            }
        }
        return bookRecommendations;
    }

    private ArrayList<User> findClosestUsers(User user, ArrayList<User> users, int range){
        HashMap<User,Double> distanceBySimiliarUserMap = new HashMap<User,Double>();

        for (User u : users){
            Double distance = getDistance(user, u);

            if (distanceBySimiliarUserMap.size() < range) {
                distanceBySimiliarUserMap.put(u, distance);
            } else {
                User furthestUser = getFurthestUser(distanceBySimiliarUserMap);

                if (distance < distanceBySimiliarUserMap.get(furthestUser)) {
                    distanceBySimiliarUserMap.remove(furthestUser);
                    distanceBySimiliarUserMap.put(u, distance);
                }
            }
        }
        return new ArrayList<User>(distanceBySimiliarUserMap.keySet());
    }

    public User getFurthestUser(HashMap<User,Double> distanceBySimiliarUserMap){
        User furthestUser = null;

        for (User u : distanceBySimiliarUserMap.keySet()){
            if (furthestUser == null){
                furthestUser = u;
            } else {
                if (distanceBySimiliarUserMap.get(u) > distanceBySimiliarUserMap.get(furthestUser)){
                    furthestUser = u;
                }
            }
        }
        return furthestUser;
    }
}
