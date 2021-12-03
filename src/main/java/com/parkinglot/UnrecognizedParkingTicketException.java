package com.parkinglot;

public class UnrecognizedParkingTicketException extends RuntimeException{
    UnrecognizedParkingTicketException(String msg){
        super(msg);
    }
}
