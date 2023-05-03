package com.example.dealcrudoperations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class CustomerEntity {
    private String firstName;
    private Long phoneNumber;
    private String email;
    private String addressLine;
    private String city;
    private String state;
    private String country;

}
