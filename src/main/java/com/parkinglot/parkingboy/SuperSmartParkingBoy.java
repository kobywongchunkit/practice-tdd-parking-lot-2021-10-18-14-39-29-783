package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;


public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    @Override
    public Ticket park(Car car){
        if(parkingLot.stream().noneMatch(ParkingLot::hasAvailablePosition))
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        return parkingLot.stream()
                .min(Comparator.comparing(ParkingLot::getAvailablePositionRate))
                .get()
                .park(car);
    }
}
