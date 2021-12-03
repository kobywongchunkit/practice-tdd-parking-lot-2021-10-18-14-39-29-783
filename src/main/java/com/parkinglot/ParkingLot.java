package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<Ticket, Car> ticketCarMap = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }
}