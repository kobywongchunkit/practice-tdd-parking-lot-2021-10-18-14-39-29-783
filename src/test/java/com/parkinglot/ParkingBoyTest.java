package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_boy_with_one_parking_lot(){
        //given
        ParkingBoy parkingboy = new ParkingBoy(new ParkingLot());
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
    }
}
