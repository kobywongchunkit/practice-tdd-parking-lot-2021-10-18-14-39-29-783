package com.parkinglot;

import com.parkinglot.Exception.NoAvailablePositionException;

import java.util.List;
import java.util.Optional;

import static com.parkinglot.Exception.ExceptionMessage.noAvailablePositionExceptionMessage;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }
    @Override
    public Ticket park(Car car){
        return null;
    }
}
