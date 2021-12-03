package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.parkingboy.ParkingBoy;
import com.parkinglot.parkingboy.ParkingLotManager;
import com.parkinglot.parkingboy.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotManagerTest {
    @Test
    void should_return_ticket_when_park_car_by_parking_boy_given_parking_lot_manager_with_parkingBoy_and_a_car() {
        //given
        ParkingBoy parkingBoy_1 = new ParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        ParkingBoy parkingBoy_2 = new SuperSmartParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        ParkingLotManager parkinglotmanager = new ParkingLotManager(null,new ArrayList<>(Arrays.asList(parkingBoy_1,parkingBoy_2)));
        //When
        Ticket ticket = parkinglotmanager.parkByBoy(1,new Car());
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_when_fetch_car_by_parking_boy_given_parking_lot_manager_with_parkingBoy_and_a_parked_car() {
        //given
        ParkingBoy parkingBoy_1 = new ParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        ParkingBoy parkingBoy_2 = new SuperSmartParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        Car car = new Car();
        Ticket ticket = parkingBoy_2.park(car);
        ParkingLotManager parkinglotmanager = new ParkingLotManager(null,new ArrayList<>(Arrays.asList(parkingBoy_1,parkingBoy_2)));
        //When
        Car fetchedCar = parkinglotmanager.fetchFromBoy(ticket);
        //then
        assertEquals(car, fetchedCar);
    }
    @Test
    void should_return_correct_car_when_fetch_car_by_parking_boy_given_parking_lot_manager_with_parkingBoy_and_two_parked_car() {
        //given
        ParkingBoy parkingBoy_1 = new ParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        ParkingBoy parkingBoy_2 = new SuperSmartParkingBoy(new ArrayList<>(Arrays.asList(new ParkingLot(), new ParkingLot())));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLotManager parkinglotmanager = new ParkingLotManager(null,new ArrayList<>(Arrays.asList(parkingBoy_1,parkingBoy_2)));
        //When
        Car fetchedCar1 = parkinglotmanager.fetchFromBoy(parkingBoy_1.park(car1));
        Car fetchedCar2 = parkinglotmanager.fetchFromBoy(parkingBoy_2.park(car2));
        //then
        assertEquals(fetchedCar1, car1);
        assertEquals(fetchedCar2, car2);
    }
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_manager_with_one_parking_lot(){
        //given
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(new ParkingLot());
        ParkingLotManager parkinglotmanager = new ParkingLotManager(ParkingLotList, null);
        Ticket ticket = parkinglotmanager.park(new Car());
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_manager_with_two_parking_lot(){
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        List<ParkingLot> ParkingLotList= new ArrayList<>();
        ParkingLotList.add(firstParkingLot);
        ParkingLotList.add(secondParkingLot);
        ParkingLotManager parkinglotmanager = new ParkingLotManager(ParkingLotList, null);
        Ticket ticket = parkinglotmanager.park(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10,secondParkingLot.getAvailablePosition());
    }
}
