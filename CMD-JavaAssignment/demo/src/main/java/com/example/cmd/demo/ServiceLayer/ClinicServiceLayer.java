package com.example.cmd.demo.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmd.demo.DTOs.Clinics;
import com.example.cmd.demo.Interface.ClinicInterface;
import com.example.cmd.demo.RepositoryLayer.ClinicRepository;

import java.math.BigInteger;

@Service
public class ClinicServiceLayer implements ClinicInterface {

    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicServiceLayer(ClinicRepository clinicRepository)
    {
        this.clinicRepository=clinicRepository;
    }

    @Override
    public void createclinic(Clinics clinics) {

        clinics.setServiceTag(getTotalClinicsCount().add(BigInteger.ONE));

        clinicRepository.save(clinics);
    }

    @Override
    public BigInteger getTotalClinicsCount() {
        return (clinicRepository.customcount());
    }

    @Override
    public boolean clinicIdExists(Clinics clinics) {
        // Clinics clinics2 = clinicRepository.findByClinicId(clinics.getClinicId());

        // System.out.println(clinics2);

        if (clinicRepository.findByClinicId(clinics.getClinicId()) != null) {
            return (false);
        }

        return (true);
    }

}
