package com.parkinglot;

class ParkingUnit {
    private String unitNumber;
    private VehicleType unitType;
    private boolean isOccupied;
    private Vehicle vehicle;
    
    public ParkingUnit(String unitNumber, VehicleType unitType, boolean isOccupied, Vehicle vehicle) {
        this.unitNumber = unitNumber;
        this.unitType = unitType;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public VehicleType getUnitType() {
        return unitType;
    }

    public void setUnitType(VehicleType unitType) {
        this.unitType = unitType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public Vehicle vacate() {
        if (this.vehicle != null) {
            this.isOccupied = false;
            var vacated = this.vehicle;
            this.vehicle = null;
            return vacated;
        } else {
            throw new IllegalArgumentException();
        }
    }
}