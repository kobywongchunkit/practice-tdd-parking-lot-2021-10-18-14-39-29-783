package com.parkinglot.Exception;

public class NoAvailablePositionException extends RuntimeException{
    public NoAvailablePositionException(String msg){
        super(msg);
    }

}
