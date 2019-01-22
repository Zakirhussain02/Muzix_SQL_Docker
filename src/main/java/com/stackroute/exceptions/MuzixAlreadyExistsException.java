package com.stackroute.exceptions;

//exception class

public class MuzixAlreadyExistsException extends Exception {

    // variable assigned

    public String message;

    //constructor

    public MuzixAlreadyExistsException(){}


    //exception constructor

    public MuzixAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }

}
