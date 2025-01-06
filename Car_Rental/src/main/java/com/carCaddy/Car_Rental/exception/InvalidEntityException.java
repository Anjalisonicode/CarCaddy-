package com.carCaddy.Car_Rental.exception;

public class InvalidEntityException extends RuntimeException { // Extend RuntimeException for unchecked exception
    public InvalidEntityException(String msg) {
        super(msg); // Pass the error message to the superclass
    }
}
