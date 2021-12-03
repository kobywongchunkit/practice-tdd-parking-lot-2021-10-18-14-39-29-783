package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.parkinglot.exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;

public class ParkingLotManager extends ParkingBoy{
    public List<ParkingBoy> parkingBoy;
    public ParkingLotManager(List<ParkingLot> parkingLot,List<ParkingBoy> parkingBoy) {
        super(parkingLot);
        this.parkingBoy = parkingBoy;
    }

    public Ticket parkByBoy(int boyIndex, Car car) {
        if(parkingBoy == null || parkingBoy.size() < boyIndex)
            return null;
        return parkingBoy.get(boyIndex).park(car);
    }

    public Car fetchFromBoy(Ticket ticket) {
        Optional<ParkingBoy> validParkingBoytoFetchCar = parkingBoy.stream().filter(parkingBoy -> parkingBoy.isTicketCanFetchCar(ticket)).findFirst();
        if (!validParkingBoytoFetchCar.isPresent())
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMessage);
        else
            return validParkingBoytoFetchCar.get().fetch(ticket);
    }
}
