package com.parkinglot;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car){
        ParkingLot availableLot = parkingLot.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0).findFirst().get();
        return availableLot.park(car);
    }
}
