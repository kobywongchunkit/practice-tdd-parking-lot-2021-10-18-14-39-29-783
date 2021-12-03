package com.parkinglot;

import com.parkinglot.Exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.parkinglot.Exception.ExceptionMessage.noAvailablePositionExceptionMessage;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    @Override
    public Ticket park(Car car){
        return null;
    }
}
