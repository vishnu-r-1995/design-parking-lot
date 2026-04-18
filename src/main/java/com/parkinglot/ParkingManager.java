package com.parkinglot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

class ParkingManager {
    private HashMap<VehicleType, List<ParkingUnit>> allUnits = new HashMap<>();
    private HashMap<String, ParkingUnit> occupiedUnits;
    private HashMap<String, Ticket> tickets;

    public ParkingManager(HashMap<VehicleType, List<ParkingUnit>> allUnits, HashMap<String, ParkingUnit> occupiedUnits,
            HashMap<String, Ticket> tickets) {
        this.allUnits = allUnits;
        this.occupiedUnits = new HashMap<>();
        this.tickets = new HashMap<>();
    }

    public void parkVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getVehicleType();
        for (VehicleType t : VehicleType.values()) {
            if (t.ordinal() >= type.ordinal()) {
                for (ParkingUnit unit : allUnits.get(t)) {
                    if (!unit.isOccupied()) {
                        unit.park(vehicle);
                        occupiedUnits.put(vehicle.getVehicleNumber(), unit);
                        tickets.put(vehicle.getVehicleNumber(), new Ticket(unit, LocalDateTime.now()));
                        return;
                    }
                }
            }
        }
    }

    public void vacateVehicle(Vehicle vehicle) {
        ParkingUnit unit = occupiedUnits.get(vehicle.getVehicleNumber());
        unit.vacate();
        occupiedUnits.remove(vehicle.getVehicleNumber());
        allUnits.get(unit.getUnitType()).add(unit);
        Ticket ticket = tickets.get(vehicle.getVehicleNumber());
        ticket.calculate();
    }

    public HashMap<VehicleType, List<ParkingUnit>> getAllUnits() {
        return allUnits;
    }

    public void setAllUnits(HashMap<VehicleType, List<ParkingUnit>> allUnits) {
        this.allUnits = allUnits;
    }

    public HashMap<String, ParkingUnit> getOccupiedUnits() {
        return occupiedUnits;
    }

    public void setOccupiedUnits(HashMap<String, ParkingUnit> occupiedUnits) {
        this.occupiedUnits = occupiedUnits;
    }

    public HashMap<String, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<String, Ticket> tickets) {
        this.tickets = tickets;
    }
}