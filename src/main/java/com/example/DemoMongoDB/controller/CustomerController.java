package com.example.DemoMongoDB.controller;

import com.example.DemoMongoDB.domain.Customer;
import com.example.DemoMongoDB.exception.CustomerNotFoundException;
import com.example.DemoMongoDB.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customerData/api/")
public class CustomerController {

    private CustomerService customerService;
     @Autowired
    public CustomerController(CustomerService customerService){
         this.customerService=customerService;
     }

     @PostMapping("/customer/")
     public ResponseEntity<?>insertCustomer(@RequestBody Customer customer)
     {
         Customer customer1=customerService.saveCustomer(customer);
         return new ResponseEntity<>(customer, HttpStatus.CREATED);
     }

     @GetMapping("/customers/")
     public ResponseEntity<?> fetchAllCustomer()
     {
         ResponseEntity responseEntity = null;
         try {
             responseEntity= new ResponseEntity<>(customerService.getAllCustomerData(),HttpStatus.OK);

         }catch (Exception e){
             e.printStackTrace();
         }
         return responseEntity;
     }

     @DeleteMapping("customer/{customerId}")
    public ResponseEntity<?> deleteSingleCustomer(@PathVariable("customerId") int customerId) throws CustomerNotFoundException {

        // return customerService.deleteCustomer(customerId);
        ResponseEntity responseEntity=null;
        try{
            customerService.deleteCustomer(customerId);
            responseEntity=new ResponseEntity<>("Successfully Deleted 1 record",HttpStatus.OK);

        }catch (CustomerNotFoundException e){

            throw new CustomerNotFoundException();

        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("customer/{city}")
    public ResponseEntity<?> fetchByCity(@PathVariable String city){

        ResponseEntity responseEntity=null;

        try{
            responseEntity=new ResponseEntity(customerService.getAllCustomerByCity(city),HttpStatus.FOUND);
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
