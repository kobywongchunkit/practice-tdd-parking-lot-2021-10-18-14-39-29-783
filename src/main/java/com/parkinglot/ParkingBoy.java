package com.parkinglot;

import com.parkinglot.Exception.*;

import java.util.List;
import java.util.Optional;


import static com.parkinglot.Exception.ExceptionMessage.noAvailablePositionExceptionMessage;
import static com.parkinglot.Exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;

public class ParkingBoy {
    private List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car){
        Optional<ParkingLot> validParkingLottoPark = parkingLot.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0).findFirst();
        if(!validParkingLottoPark.isPresent())
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        else
             return validParkingLottoPark.get().park(car);
    }

    public Car fetch(Ticket ticket) {

        Optional<ParkingLot> validTickettoFetchCar = parkingLot.stream().filter(parkingLot -> parkingLot.isTicketValid(ticket)).findFirst();

        if (!validTickettoFetchCar.isPresent())
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage);
        else
            return validTickettoFetchCar.get().fetch(ticket);
    }
}
