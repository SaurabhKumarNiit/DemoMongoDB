package com.example.DemoMongoDB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "customer id not found please check")
public class CustomerNotFoundException extends Exception{

    public  CustomerNotFoundException (){
        super();
    }
}
