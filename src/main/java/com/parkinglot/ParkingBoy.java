package com.parkinglot;

import com.parkinglot.Exception.*;

import java.util.List;
import java.util.Optional;


import static com.parkinglot.Exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;

public class ParkingBoy {
    private List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }
    public Ticket park(Car car){
        return parkingLot.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .park(car);
    }

    public Car fetch(Ticket ticket) {

        Optional<ParkingLot> validParkinglot = parkingLot.stream().filter(parkingLot -> parkingLot.isTicketValid(ticket)).findFirst();

        if (!validParkinglot.isPresent())
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage);
        else
            return validParkinglot.get().fetch(ticket);
    }
}
