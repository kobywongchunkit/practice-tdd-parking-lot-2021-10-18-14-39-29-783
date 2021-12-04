package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.List;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;
import static com.parkinglot.exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;


public class ParkingLotManager extends ParkingBoy{
    private final List<ParkingBoy> managementList;
    public ParkingLotManager(List<ParkingLot> parkingLot,List<ParkingBoy> managementList) {
        super(parkingLot);
        this.managementList = managementList;
    }

    public Ticket parkByBoy(int boyIndex, Car car) {
        if(managementList == null || managementList.size()  < boyIndex + 1 )
            throw new NoAvailablePositionException(noAvailablePositionExceptionMessage);
        return managementList.get(boyIndex).park(car);
    }

    public Car fetchFromBoy(Ticket ticket) {
        return managementList.stream()
                .filter(parkingBoy -> parkingBoy.isTicketCanFetchCar(ticket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage))
                .fetch(ticket);
    }
}
