package com.example.dealcrudoperations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
    public class DealDto {
    private Integer Id;
    private String source;
    private String sourceTag;
    private String dealNumber;
    private String dealershipId;
    private String saleStatus;
    private String saleType;
    private Instant soldTime;
    private CustomerDto customerdto;
    private VehicleDto vehicleDto;
    public SalesRepDto salesRepDto;
}
