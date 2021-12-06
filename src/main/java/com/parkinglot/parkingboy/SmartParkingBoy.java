package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }
    @Override
    public Ticket park(Car car){
        if(parkingLot.stream().noneMatch(ParkingLot::hasAvailablePosition))
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        return parkingLot.stream()
                .max(Comparator.comparing(ParkingLot::getAvailablePositionCount))
                .get()
                .park(car);

    }
}
