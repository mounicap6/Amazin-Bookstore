package com.amazon.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Before;

public class JaccardDistanceTest {

    @Autowired
    private JaccardDistance jaccardDistance;

    private User user1, user2, user3;
    private Book book1, book2, book3, book4;
    private ShoppingCart shoppingCart;

    //runs before every test 
    @Before
    public void setUp(){
        this.user1 = new User("user1");
        this.user2 = new User("user2");
        this.user3 = new User("user3");

        this.book1 = new Book("Book1", "Paulo Coelho", "HarperCollins", 97800613, "pursue your dreams by following what your heart desires", "Adventure",3,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book2 = new Book("Book2", "Paulo Coelho", "HarperCollins", 34534534, "des", "Adventure",3,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book3 = new Book("Book3", "Paulo Coelho", "HarperCollins", 13453456, "descrip", "Adventure",6,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");
        this.book4 = new Book("Book4", "Paulo Coelho", "HarperCollins", 66956564, "description", "Adventure",4,"https://upload.wikimedia.org/wikipedia/en/c/c4/TheAlchemist.jpg");

        user1.addToCart(book1);
        shoppingCart.addBook(book1);
        shoppingCart.getBooks();

        //ShoppingCart shoppingCart1 = this.user1.getShoppingCart();
       // shoppingCart1.addBook(this.book1);
        //shoppingCart1.addBook(this.book2);

        ShoppingCart shoppingCart2 = this.user2.getShoppingCart();
        shoppingCart2.addBook(this.book4);
        shoppingCart2.addBook(this.book2);
        shoppingCart2.addBook(this.book3);

        ShoppingCart shoppingCart3 = this.user3.getShoppingCart();
        shoppingCart3.addBook(this.book1);
        shoppingCart3.addBook(this.book4);

    }

}

