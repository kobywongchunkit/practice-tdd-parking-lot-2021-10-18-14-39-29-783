package com.parkinglot;

public class UnrecognizedParkingException extends RuntimeException{
    UnrecognizedParkingException(String msg){
        super(msg);
    }
}
