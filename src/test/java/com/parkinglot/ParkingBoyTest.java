package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_boy_with_one_parking_lot(){
        //given
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(new ParkingLot());
        ParkingBoy parkingboy = new ParkingBoy(ParkingLotList);
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_bot_with_two_parking_lot(){
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new ParkingBoy(ParkingLotList);
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }
}
