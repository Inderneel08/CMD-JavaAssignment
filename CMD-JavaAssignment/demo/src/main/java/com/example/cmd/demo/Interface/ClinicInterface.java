package com.example.cmd.demo.Interface;

import java.math.BigInteger;

import com.example.cmd.demo.DTOs.Clinics;

public interface ClinicInterface {

    public void createclinic(Clinics clinics);

    public BigInteger getTotalClinicsCount();

    public boolean clinicIdExists(Clinics clinics);
}
