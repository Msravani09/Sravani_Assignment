package com.example.dealcrudoperations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String firstName;
    private Long phoneNumber;
    private String email;
    private String addressLine;
    private String city;
    private String state;
    private String country;

}
