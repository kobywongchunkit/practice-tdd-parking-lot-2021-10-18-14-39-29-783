package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.exception.*;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.List;
import java.util.Optional;


import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;
import static com.parkinglot.exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;

public class ParkingBoy {
    protected List<ParkingLot> parkingLot;
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

        Optional<ParkingLot> validParkingLotFetchByTicket = parkingLot.stream().filter(parkingLot -> parkingLot.isTicketValid(ticket)).findFirst();

        if (!validParkingLotFetchByTicket.isPresent())
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage);
        else
            return validParkingLotFetchByTicket.get().fetch(ticket);
    }

    public boolean isTicketCanFetchCar(Ticket ticket){
        return parkingLot.stream().anyMatch(parkingLot -> parkingLot.isTicketValid(ticket));
    }
}
