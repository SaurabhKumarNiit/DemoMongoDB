package com.example.DemoMongoDB.repository;

import com.example.DemoMongoDB.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    @Query("{'address.city':{$in : [?0]}}")
    List<Customer> findAllCustomerFromCity(String city);

    //public Customer findByEmail(String email);
}
