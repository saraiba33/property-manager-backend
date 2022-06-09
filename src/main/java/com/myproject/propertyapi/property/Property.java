package com.myproject.propertyapi.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "propertydata")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "image")
    private String image;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @Column(name = "end_date")
    private String endDate;
}