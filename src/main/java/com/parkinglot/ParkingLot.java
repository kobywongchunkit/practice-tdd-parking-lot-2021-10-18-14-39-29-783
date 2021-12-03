package com.parkinglot;

import com.parkinglot.Exception.NoAvailablePositionException;
import com.parkinglot.Exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

import static com.parkinglot.Exception.ExceptionMessage.*;

public class ParkingLot {
    Map<Ticket, Car> ticketCarMap = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity){ this.capacity = capacity;}
    public ParkingLot(){this.capacity = 10;}
    public Ticket park(Car car) {
        if (!hasAvailablePosition())
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }
    private boolean hasAvailablePosition(){
        return ticketCarMap.size() < capacity;
    }
    public int getAvailablePosition(){
        return capacity - ticketCarMap.size();
    }
    public Car fetch(Ticket ticket) {
        if (!isTicketValid(ticket))
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage);
        Car fetchedCar = ticketCarMap.get(ticket);
        if (fetchedCar != null){
            ticketCarMap.remove(ticket);
        }
        return fetchedCar;
    }

    public boolean isTicketValid(Ticket ticket){
        return ticketCarMap.containsKey(ticket);
    }
}