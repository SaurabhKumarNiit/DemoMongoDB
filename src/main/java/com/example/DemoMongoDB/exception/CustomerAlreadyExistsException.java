package com.example.DemoMongoDB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.ALREADY_REPORTED,reason = "customer already exists please check !!")
public class CustomerAlreadyExistsException extends Exception {

}
