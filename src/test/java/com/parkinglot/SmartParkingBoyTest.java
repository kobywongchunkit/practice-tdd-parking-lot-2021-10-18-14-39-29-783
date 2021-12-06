package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.parkingboy.ParkingBoy;
import com.parkinglot.parkingboy.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.parkinglot.exception.ExceptionMessage.noAvailablePositionExceptionMessage;
import static com.parkinglot.exception.ExceptionMessage.unrecognizedParkingTicketExceptionMessage;
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
        assertEquals(9, firstParkingLot.getAvailablePositionCount());
        assertEquals(10,secondParkingLot.getAvailablePositionCount());
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
        assertEquals(0, firstParkingLot.getAvailablePositionCount());
        assertEquals(9, secondParkingLot.getAvailablePositionCount());
    }
    @Test
    void should_return_two_car_when_fetch_two_car_given_smart_parking_boy_with_two_parking_lot_with_two_parked_car_in_different_parking_lot(){
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = firstParkingLot.park(car1);
        Ticket ticket2 = secondParkingLot.park(car2);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        //when
        Car fetchedCar1 = parkingboy.fetch(ticket1);
        Car fetchedCar2 = parkingboy.fetch(ticket2);
        //then
        assertEquals(fetchedCar1, car1);
        assertEquals(fetchedCar2, car2);
    }
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_Smart_parking_boy_with_two_parking_lot_and_used_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        Ticket ticket = firstParkingLot.park(new Car());
        firstParkingLot.fetch(ticket);
        //When
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingboy.fetch(ticket);
        });
        assertEquals(unrecognizedParkingTicketExceptionMessage, unrecognizedParkingTicketException.getMessage());
    }
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_boy_with_two_parking_lot_and_unrecognized_ticket() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        Ticket ticket = new Ticket();
        //When
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingboy.fetch(ticket);
        });
        assertEquals(unrecognizedParkingTicketExceptionMessage, unrecognizedParkingTicketException.getMessage());
    }
    @Test
    void should_throw_no_available_position_when_park_car_given_smart_parking_boy_with_two_parking_full_parking_lot_and_car(){
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        firstParkingLot.park(new Car());
        secondParkingLot.park(new Car());
        //when
        //then
        NoAvailablePositionException noAvailablePositionException =assertThrows(NoAvailablePositionException.class,()->{
            parkingboy.park(new Car());
        });
        assertEquals(noAvailablePositionExceptionMessage, noAvailablePositionException.getMessage());
    }
    @Test
    void should_park_at_parking_lot_with_more_space_when_park_car_given_smart_parking_boy_with_two_parking_lot_and_parking_lot_2_is_with_more_space(){
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot(20);
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingBoy parkingboy = new SmartParkingBoy(ParkingLotList);
        //When
        Ticket ticket = parkingboy.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(10, firstParkingLot.getAvailablePositionCount());
        assertEquals(19, secondParkingLot.getAvailablePositionCount());
    }

}
