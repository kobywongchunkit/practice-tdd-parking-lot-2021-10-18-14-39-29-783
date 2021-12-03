package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<Ticket, Car> ticketCarMap = new HashMap<>();
    private  int capacity;
    public ParkingLot(int capacity){ this.capacity = capacity;}
    public ParkingLot(){this.capacity = 10;}
    public Ticket park(Car car) {
        if (!hasAvailablePosition()) return null;
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }
    private boolean hasAvailablePosition(){
        return ticketCarMap.size() < capacity;
    }
}