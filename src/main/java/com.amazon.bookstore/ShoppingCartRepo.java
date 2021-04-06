package com.amazon.bookstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "cart", path = "cart.json")
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUser(User u);
}
