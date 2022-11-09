package com.example.DemoMongoDB.service;

import com.example.DemoMongoDB.domain.Customer;
import com.example.DemoMongoDB.exception.CustomerAlreadyExistsException;
import com.example.DemoMongoDB.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService
{
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;

    List<Customer> getAllCustomerData() throws Exception;
    boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
    List<Customer>getAllCustomerByCity(String city) throws CustomerNotFoundException;
}
