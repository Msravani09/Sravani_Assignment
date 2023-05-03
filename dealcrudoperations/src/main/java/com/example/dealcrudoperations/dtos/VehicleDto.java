package com.example.dealcrudoperations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String stockNumber;
    private String vin;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String type;
    private String trim;

}
