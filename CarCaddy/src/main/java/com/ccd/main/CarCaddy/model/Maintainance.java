package com.ccd.main.CarCaddy.model;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity

public class Maintainance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maintenance_Id;

   private Integer car_id;

    private String description;

    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private Date maintenance_date;


    private String maintenanceType;


    private String  maintenanceStatus;

    public Maintainance() {}

    // Constructor with all fields
    public Maintainance(Integer maintenance_Id, Integer car_id, String description, Date maintenance_date, String maintenanceType, String maintenanceStatus) {
        this.maintenance_Id = maintenance_Id;
        this.car_id = car_id;
        this.description = description;
        this.maintenance_date = maintenance_date;
        this.maintenanceType = maintenanceType;
        this.maintenanceStatus = maintenanceStatus;
    }

    // Getter and Setter for maintenance_Id
    public Integer getMaintenance_Id() {
        return maintenance_Id;
    }

    public void setMaintenance_Id(Integer maintenance_Id) {
        this.maintenance_Id = maintenance_Id;
    }

    // Getter and Setter for car_id
    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for maintenance_date
    public Date getMaintenance_date() {
        return maintenance_date;
    }

    public void setMaintenance_date(Date maintenance_date) {
        this.maintenance_date = maintenance_date;
    }

    // Getter and Setter for maintenanceType
    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    // Getter and Setter for maintenanceStatus
    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    // Builder Pattern
//    public static class Builder {
//        private Integer maintenance_Id;
//        private Integer car_id;
//        private String description;
//        private Date maintenance_date;
//        private String maintenanceType;
//        private String maintenanceStatus;
//
//        public Builder maintenance_Id(Integer maintenance_Id) {
//            this.maintenance_Id = maintenance_Id;
//            return this;
//        }
//
//        public Builder car_id(Integer car_id) {
//            this.car_id = car_id;
//            return this;
//        }
//
//        public Builder description(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public Builder maintenance_date(Date maintenance_date) {
//            this.maintenance_date = maintenance_date;
//            return this;
//        }
//
//        public Builder maintenanceType(String maintenanceType) {
//            this.maintenanceType = maintenanceType;
//            return this;
//        }
//
//        public Builder maintenanceStatus(String maintenanceStatus) {
//            this.maintenanceStatus = maintenanceStatus;
//            return this;
//        }
//
//        public Maintainance build() {
//            return new Maintainance(maintenance_Id, car_id, description, maintenance_date, maintenanceType, maintenanceStatus);
//        }
    }

