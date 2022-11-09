package com.example.DemoMongoDB.service;

import com.example.DemoMongoDB.domain.Customer;
import com.example.DemoMongoDB.exception.CustomerAlreadyExistsException;
import com.example.DemoMongoDB.exception.CustomerNotFoundException;
import com.example.DemoMongoDB.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomerData() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean result=false;

         if(customerRepository.findById(customerId).isEmpty()){
             throw new CustomerNotFoundException();
         }
         else {
             customerRepository.deleteById(customerId);
             result= true;
         }
         return result;
    }

    @Override
    public List<Customer> getAllCustomerByCity(String city) throws CustomerNotFoundException {

        if(customerRepository.findAllCustomerFromCity(city).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAllCustomerFromCity(city);
    }


}
