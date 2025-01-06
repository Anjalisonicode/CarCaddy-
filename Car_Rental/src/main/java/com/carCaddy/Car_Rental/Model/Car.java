package com.carCaddy.Car_Rental.Model;

import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public class Car {
    private int car_id;
    private String registration_No;
    private String model;
    private String color;
    private int mileage;
    private Date last_maintenance;
    // No-argument constructor
    @OneToMany(mappedBy ="car_id")
    private List<Maintainance>maintainanceList;
    public Car() {
    }

    // All-argument constructor
    public Car(int car_id, String registration_No, String model, String color, int mileage, Date last_maintenance) {
        this.car_id = car_id;
        this.registration_No = registration_No;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.last_maintenance = last_maintenance;
    }

    // Getter and Setter methods
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getRegistration_No() {
        return registration_No;
    }

    public void setRegistration_No(String registration_No) {
        this.registration_No = registration_No;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Date getLast_maintenance() {
        return last_maintenance;
    }

    public void setLast_maintenance(Date last_maintenance) {
        this.last_maintenance = last_maintenance;
    }
}


