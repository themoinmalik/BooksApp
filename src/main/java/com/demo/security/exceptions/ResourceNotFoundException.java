package com.demo.security.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(String string){
        super(string);
    }
}
