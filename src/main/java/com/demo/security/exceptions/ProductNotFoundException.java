package com.demo.security.exceptions;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(String string){
        super(string);
    }
}
