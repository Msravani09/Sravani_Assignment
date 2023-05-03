package com.example.dealcrudoperations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SalesRepDto {
    private long Id;
    private String firstName;
    private String lastName;
    private String arcId;
    private String role;
}
