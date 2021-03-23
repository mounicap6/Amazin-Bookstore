package com.amazon.bookstore;

import com.amazon.bookstore.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;


@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepo extends PagingAndSortingRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Book findById(long id);
    List<Book> findByIsbn(int isbn);
    List<Book> findByTitle(String title);
    List<Book> findByDescription(String description);
    List<Book> findByAuthor(String author);
    List<Book> findByPublisher(String publisher);
    List<Book> findByGenre(String genre);
    List<Book> findByQuantity(int quantity);

}