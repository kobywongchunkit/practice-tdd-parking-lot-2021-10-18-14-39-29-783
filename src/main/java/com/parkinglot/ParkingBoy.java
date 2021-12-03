package com.parkinglot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkingBoy {
    private List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car){
        return parkingLot.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .park(car);
    }

    public Car fetch(Ticket ticket) {
        return  parkingLot.stream().filter(parkingLot -> parkingLot.isTicketValid(ticket))
                .findFirst()
                .get()
                .fetch(ticket);
    }
}
