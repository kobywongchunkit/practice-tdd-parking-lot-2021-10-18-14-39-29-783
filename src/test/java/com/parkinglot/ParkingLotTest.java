package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //When
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_null_when_park_car_given_full_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);
        //When
        Ticket ticket = parkingLot.park(car);
        //then
        assertNull(ticket);
    }
    @Test
    void should_return_parked_car_when_fetch_car_given_parking_lot_with_parked_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //When
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car,fetchedCar);
    }
    @Test
    void should_return_right_parked_car_when_fetch_car_given_parking_lot_with_two_parked_car_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);
        //then
        assertEquals(fetchedCar1, car1);
        assertEquals(fetchedCar2, car2);
    }
}
