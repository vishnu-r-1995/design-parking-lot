package com.parkinglot;

import java.time.LocalDateTime;

class Ticket {
    private ParkingUnit parkingUnit;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Price price;
    
    public Ticket(ParkingUnit parkingUnit, LocalDateTime entryTime) {
        this.parkingUnit = parkingUnit;
        this.entryTime = entryTime;
    }

    public ParkingUnit getParkingUnit() {
        return parkingUnit;
    }

    public void setParkingUnit(ParkingUnit parkingUnit) {
        this.parkingUnit = parkingUnit;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void calculate() {
        if (this.exitTime == null) {
            this.exitTime = LocalDateTime.now();
        }
        this.price = new Price(0d);
        this.price.calculatePrice(this);
    }
}