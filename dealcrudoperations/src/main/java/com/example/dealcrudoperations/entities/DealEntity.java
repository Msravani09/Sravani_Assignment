package com.example.dealcrudoperations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Embedded;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deal")
public class DealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String source;
    private String sourceTag;
    private String dealNumber;
    private String dealershipId;
    private String saleStatus;
    private String saleType;
    private Instant soldTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "stockNumber", column = @Column(name = "StockNumber")),
            @AttributeOverride(name = "vin", column = @Column(name = "Vin")),
            @AttributeOverride(name = "year", column = @Column(name = "Year")),
            @AttributeOverride(name = "make", column = @Column(name = "Make")),
            @AttributeOverride(name = "model", column = @Column(name = "Model")),
            @AttributeOverride(name = "trim", column = @Column(name = "Trim")),
            @AttributeOverride(name = "type", column = @Column(name = "type")),
            @AttributeOverride(name = "color", column = @Column(name = "Color")),


    })

    private VehicleEntity vehicleEntity;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "firstName")),
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "phoneNumber")),
            @AttributeOverride(name = "addressLine", column = @Column(name = "addressline")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "state", column = @Column(name = "state")),
            @AttributeOverride(name = "country", column = @Column(name = "country"))
    })
    private CustomerEntity customerEntity;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Sales_id")
    private SalesRepEntity salesRepEntity;

}