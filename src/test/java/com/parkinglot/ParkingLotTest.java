package com.parkinglot;

import com.parkinglot.Exception.NoAvailablePositionException;
import com.parkinglot.Exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static com.parkinglot.Exception.ExceptionMessage.*;
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
    void should_throw_no_available_position_when_park_car_given_full_parking_lot_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        Car car = new Car();
        //when
        //then
        NoAvailablePositionException noAvailablePositionException =assertThrows(NoAvailablePositionException.class,()->{
            parkingLot.park(car);
        });
        assertEquals(noAvailablePositionExceptionMessage, noAvailablePositionException.getMessage());
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
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_with_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(new Car());
        Ticket incorrectTicket = new Ticket();
        //When
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingLot.fetch(incorrectTicket);
        });
        assertEquals(unrecognizedParkingTicketExceptionMessage, unrecognizedParkingTicketException.getMessage());
    }
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_with_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.park(new Car());
        parkingLot.fetch(ticket);
        //When
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingLot.fetch(ticket);
        });
        assertEquals(unrecognizedParkingTicketExceptionMessage, unrecognizedParkingTicketException.getMessage());
    }

}
