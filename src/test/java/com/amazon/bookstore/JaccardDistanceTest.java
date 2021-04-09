package com.amazon.bookstore;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JaccardDistanceTest {

    @Autowired
    private JaccardDistance jaccardDistance;

    private User user1, user2, user3;
    private Book book1, book2, book3, book4;
    HashMap<User,Double> distanceBySimiliarUserMap = new HashMap<User,Double>();

    @BeforeEach
    public void setUp(){
        this.jaccardDistance = new JaccardDistance();

        this.user1 = new User("user1");
        this.user2 = new User("user2");
        this.user3 = new User("user3");

        this.book1 = new Book("Book1", "Paulo Coelho", "HarperCollins", 97800613, "pursue your dreams by following what your heart desires", "Adventure",3,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book2 = new Book("Book2", "Paulo Coelho", "HarperCollins", 34534534, "des", "Adventure",3,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book3 = new Book("Book3", "Paulo Coelho", "HarperCollins", 13453456, "descrip", "Adventure",6,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book4 = new Book("Book4", "Paulo Coelho", "HarperCollins", 66956564, "description", "Adventure",4,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");

        this.user1.addToCart(this.book1);
        this.user1.addToCart(this.book2);
        this.user2.addToCart(this.book1);
        this.user2.addToCart(this.book2);
        this.user3.addToCart(this.book2);
        this.user3.addToCart(this.book3);
        this.user3.addToCart(this.book4);
    }

    @Test
    public void testGetDistance(){

    }

    @Test
    public void testGetRecommendations(){

        ArrayList<User> users = new ArrayList<User>();
        users.add(this.user2);
        users.add(this.user3);

        HashSet<Book> expectedRecommendations = new HashSet<Book>();
        expectedRecommendations.add(this.book3);
        expectedRecommendations.add(this.book1);
        expectedRecommendations.add(this.book2);

        assertEquals(jaccardDistance.getRecommendation(user1, users, 2), expectedRecommendations);
    }

    @Test
    public void testFindClosestUser(){

    }

    @Test
    public void testGetFurthestUser(){
        HashMap<User, Double> distanceBySimiliarCustomerMap = new HashMap<User, Double>();

        distanceBySimiliarCustomerMap.put(this.user1, 75.00);
        distanceBySimiliarCustomerMap.put(this.user2, 33.33);
        distanceBySimiliarCustomerMap.put(this.user3, 66.67);

        assert(this.jaccardDistance.getFurthestUser(distanceBySimiliarCustomerMap).equals(this.user1));
    }
}

