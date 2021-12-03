package com.parkinglot.exception;

public class UnrecognizedParkingTicketException extends RuntimeException{
    public UnrecognizedParkingTicketException(String msg){
        super(msg);
    }
}
