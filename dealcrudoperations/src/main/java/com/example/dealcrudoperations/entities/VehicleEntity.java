package com.example.dealcrudoperations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class VehicleEntity {

    private String stockNumber;
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String type;
    private String trim;


}
