package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
    @Override
    public Ticket park(Car car){
        Optional<ParkingLot> validParkingLottoPark = parkingLot.stream().min(Comparator.comparing(ParkingLot::getAvailablePositionRate));
        if(!validParkingLottoPark.isPresent())
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        else
            return validParkingLottoPark.get().park(car);
    }
}
