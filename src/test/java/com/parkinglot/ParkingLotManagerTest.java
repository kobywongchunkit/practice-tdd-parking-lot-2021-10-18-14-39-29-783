package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.parkingboy.ParkingBoy;
import com.parkinglot.parkingboy.ParkingLotManager;
import com.parkinglot.parkingboy.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


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

}
