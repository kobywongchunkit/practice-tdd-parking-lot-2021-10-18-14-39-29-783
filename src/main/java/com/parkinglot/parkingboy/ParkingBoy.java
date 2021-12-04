package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.List;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;
import static com.parkinglot.exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;


public class ParkingBoy {
    protected List<ParkingLot> parkingLot;
    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car){
         return parkingLot.stream()
                 .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                 .findFirst()
                 .orElseThrow(() -> new NoAvailablePositionException(noAvailablePositionExceptionMessage))
                 .park(car);
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.stream()
                .filter(parkingLot -> parkingLot.isTicketValid(ticket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage))
                .fetch(ticket);
    }

    public boolean isTicketCanFetchCar(Ticket ticket){
        return parkingLot.stream().anyMatch(parkingLot -> parkingLot.isTicketValid(ticket));
    }
}
