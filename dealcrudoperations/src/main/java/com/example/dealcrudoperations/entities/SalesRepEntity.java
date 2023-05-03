package com.example.dealcrudoperations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SALES_REP")
public class SalesRepEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long Id;
        private String firstName;
        private String lastName;
        private String arcId;
        private String role;

}
