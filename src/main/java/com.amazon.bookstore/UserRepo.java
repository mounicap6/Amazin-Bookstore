package com.amazon.bookstore;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepo extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findById(int id);
    User findByName(String name);

}
