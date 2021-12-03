package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import java.util.Comparator;
import java.util.List;


public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    @Override
    public Ticket park(Car car){
        return parkingLot.stream()
                .min(Comparator.comparing(ParkingLot::getAvailablePositionRate))
                .get()
                .park(car);
    }
}
