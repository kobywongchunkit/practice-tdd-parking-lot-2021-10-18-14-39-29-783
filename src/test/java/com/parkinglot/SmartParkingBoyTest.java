package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_smart_parking_boy_with_two_parking_lot(){
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }
    @Test
    void should_return_ticket_when_park_car_given_smart_parking_boy_with_two_parking_lot_and_parking_lot_1_is_full(){
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        firstParkingLot.park(new Car());
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        //When
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(0, firstParkingLot.getAvailablePosition());
        assertEquals(9, secondParkingLot.getAvailablePosition());
    }
}
