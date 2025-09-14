package com.developeWtihAli.BooklyshopApp.customer.repository;

import com.developeWtihAli.BooklyshopApp.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer , String> {

    Optional<Customer> findByUserName(String userName);
    boolean existsByUserName(String userName);

}
