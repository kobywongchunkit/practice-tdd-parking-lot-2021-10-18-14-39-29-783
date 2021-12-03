package com.parkinglot.Exception;

public class UnrecognizedParkingTicketException extends RuntimeException{
    public UnrecognizedParkingTicketException(String msg){
        super(msg);
    }
}
