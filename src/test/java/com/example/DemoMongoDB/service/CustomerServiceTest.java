package com.example.DemoMongoDB.service;

import com.example.DemoMongoDB.exception.CustomerAlreadyExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.DemoMongoDB.domain.Address;
import com.example.DemoMongoDB.domain.Customer;
import com.example.DemoMongoDB.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer1,customer2;
    List<Customer> customerList;

    Address address1,address2;

    @BeforeEach
    public void setUp()
    {
        address1=new Address("Pune","MH","India","25643");
        address2=new Address("Bhopal","MP","India","65239");
        customer1=new Customer(102,"Jagga","Jagga@gmail.com",address1);
        customer2=new Customer(111,"Bala","Bala@gmail.com",address2);

        customerList= Arrays.asList(customer1,customer2);
    }
    @AfterEach
    void tearDown(){
        customer1=null;
        customer2 = null;
    }

    @Test
    public void givenCustomerToSaveData() throws CustomerAlreadyExistsException
    {
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.save(any())).thenReturn(customer1);
        assertEquals(customer1,customerService.saveCustomer(customer1));
        verify(customerRepository,times(1)).save(any());
        verify(customerRepository,times(1)).findById(any());
    }

}
