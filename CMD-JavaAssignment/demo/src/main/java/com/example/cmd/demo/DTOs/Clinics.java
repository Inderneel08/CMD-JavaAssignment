package com.example.cmd.demo.DTOs;

import java.math.BigInteger;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "clinics")
@Data
public class Clinics {
    // Total 13

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "clinicId")
    private String clinicId;

    @Column(name = "clinicName")
    private String clinicName;

    @Column(name = "buisnessName")
    private String buisnessName;

    @Column(name = "streetAddress")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "serviceTag")
    private BigInteger serviceTag;

    @Column(name = "dateCreated")
    private Date dateCreated;
}
