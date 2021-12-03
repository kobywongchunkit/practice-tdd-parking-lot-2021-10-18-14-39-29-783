package com.parkinglot.parkingboy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy{
    List<ParkingBoy> parkingBoy;
    public ParkingLotManager(List<ParkingLot> parkingLot,List<ParkingBoy> parkingBoy) {
        super(parkingLot);
        this.parkingBoy = parkingBoy;
    }

    public Ticket parkByBoy(int boyIndex, Car car) {
        return null;
    }
}
