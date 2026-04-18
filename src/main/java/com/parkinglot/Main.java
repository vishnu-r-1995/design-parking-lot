package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
        ParkingManager pm = new ParkingManager(null, null, null);
        
        var smallUnits = new ArrayList<ParkingUnit>();
        smallUnits.add(new ParkingUnit("A1", VehicleType.SMALL, false, null));
        smallUnits.add(new ParkingUnit("A2", VehicleType.SMALL, false, null));
        var mediumUnits = new ArrayList<ParkingUnit>();
        mediumUnits.add(new ParkingUnit("B1", VehicleType.MEDIUM, false, null));
        mediumUnits.add(new ParkingUnit("B2", VehicleType.MEDIUM, false, null));
        var heavyUnits = new ArrayList<ParkingUnit>();
        heavyUnits.add(new ParkingUnit("C1", VehicleType.MEDIUM, false, null));
        heavyUnits.add(new ParkingUnit("C2", VehicleType.MEDIUM, false, null));
        var map = new HashMap<VehicleType, List<ParkingUnit>>();
        map.put(VehicleType.SMALL, smallUnits);
        map.put(VehicleType.MEDIUM, mediumUnits);
        map.put(VehicleType.SMALL, heavyUnits);
        pm.setAllUnits(map);

        Vehicle v1 = new Vehicle("KL01A123", VehicleType.SMALL);
        Vehicle v2 = new Vehicle("KL07A123", VehicleType.MEDIUM);
        Vehicle v3 = new Vehicle("KL07A789", VehicleType.MEDIUM);
        pm.parkVehicle(v1);
        pm.vacateVehicle(v1);
        pm.parkVehicle(v2);
        pm.parkVehicle(v3);
        pm.vacateVehicle(v3);
    }
}