package com.capg.onlineSweetMart.exception;

public class SweetItemNotFoundException extends RuntimeException{
    public SweetItemNotFoundException(String message) {
        super(message);
    }

    public SweetItemNotFoundException(){

        super("Medicine with this id not found");
    }
}
