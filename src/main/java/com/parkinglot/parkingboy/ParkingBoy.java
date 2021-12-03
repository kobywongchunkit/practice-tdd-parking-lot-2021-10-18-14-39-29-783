package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.List;


public class ParkingBoy {
    protected List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car){
         return parkingLot.stream()
                 .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                 .findFirst()
                 .orElse(parkingLot.get(parkingLot.size()-1))
                 .park(car);
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.stream()
                .filter(parkingLot -> parkingLot.isTicketValid(ticket))
                .findFirst()
                .orElse(parkingLot.get(parkingLot.size()-1))
                .fetch(ticket);
    }

    public boolean isTicketCanFetchCar(Ticket ticket){
        return parkingLot.stream().anyMatch(parkingLot -> parkingLot.isTicketValid(ticket));
    }
}
