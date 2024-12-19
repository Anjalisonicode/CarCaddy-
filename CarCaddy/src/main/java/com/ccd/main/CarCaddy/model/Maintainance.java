package com.ccd.main.CarCaddy.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Maintainance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maintenance_Id;

   // private Car car;

    private String description;

    @CreationTimestamp
    private Date maintenance_date;


    private String maintenanceType;


    private String  maintenanceStatus;






}
