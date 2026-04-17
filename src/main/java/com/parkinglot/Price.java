package com.parkinglot;

import java.time.Duration;

class Price {

    private double value;

    public Price(double value) {
        this.value = value;
    }

    public void calculatePrice(Ticket ticket) {
        int multiplier = 1;
        if (ticket.getParkingUnit().getUnitType() == VehicleType.SMALL) {
            multiplier = 1;
        } else if (ticket.getParkingUnit().getUnitType() == VehicleType.MEDIUM) {
            multiplier = 2;
        } else if (ticket.getParkingUnit().getUnitType() == VehicleType.HEAVY) {
            multiplier = 3;
        } else {
            throw new IllegalArgumentException();
        }

        Duration d = Duration.between(ticket.getExitTime(), ticket.getEntryTime());
        double result = d.toMinutes() * multiplier;
        this.value = result;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}