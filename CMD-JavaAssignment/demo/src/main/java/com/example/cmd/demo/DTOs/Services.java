package com.example.cmd.demo.DTOs;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "services")
public class Services {
    // Total 7

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceId")
    private BigInteger serviceId;

    @Column(name = "serviceTag")
    private BigInteger serviceTag;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "serviceCode")
    private String serviceCode;

    @Column(name = "serviceDescription")
    private String serviceDescription;

    @Column(name = "avgPrice")
    private Integer avgPrice;

    @Column(name = "isActive")
    private Integer isActive;

}
