package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }
    @Override
    public Ticket park(Car car){
        return parkingLot.stream()
                .max(Comparator.comparing(ParkingLot::getAvailablePosition))
                .get()
                .park(car);

    }
}
