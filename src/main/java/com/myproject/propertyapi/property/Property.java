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

    @Column(name = "rent_amount")
    private long rentAmount;

    @Column(name = "tenant_1")
    private String tenant1;

    @Column(name = "tenant_1_contact")
    private String tenant1Contact;

    @Column(name = "tenant_2")
    private String tenant2;

    @Column(name = "tenant_2_contact")
    private String tenant2Contact;

    @Column(name = "emergency_1")
    private String emergencyContact1;

    @Column(name = "emergency_number_1")
    private String emergencyNumber1;

    @Column(name = "emergency_2")
    private String emergencyContact2;

    @Column(name = "emergency_number_2")
    private String emergencyNumber2;

}