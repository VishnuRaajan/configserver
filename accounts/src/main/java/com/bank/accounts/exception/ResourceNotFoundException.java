package com.bank.accounts.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resource,String field,String fieldValue) {

        super(String.format("%s not found with %s : '%s'",resource,field,fieldValue));
    }
}
