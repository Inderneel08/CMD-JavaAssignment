package com.example.cmd.demo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Date;
import com.example.cmd.demo.DTOs.Clinics;
import com.example.cmd.demo.RepositoryLayer.ClinicRepository;
import com.example.cmd.demo.ServiceLayer.ClinicServiceLayer;

@ExtendWith(MockitoExtension.class)
class ClinicServiceTest {

    @Mock
    private ClinicRepository clinicRepository;

    private ClinicServiceLayer clinicServiceLayer;

    @Test
    void clinicIdExists() {
        Clinics clinics = new Clinics();
        clinics.setClinicId("CL202200001");
        clinics.setClinicName("Some_Clinic");
        clinics.setBuisnessName("Some_Buisness");
        clinics.setStreetAddress("Some_Street");
        clinics.setCity("Some_City");
        clinics.setState("Some_State");
        clinics.setCountry("Some_Country");
        clinics.setZipCode("Some_ZipCode");
        clinics.setLatitude(91.12);
        clinics.setLongitude(-82.21);
        clinics.setServiceTag(BigInteger.valueOf(5));
        clinics.setDateCreated(new Date(System.currentTimeMillis()));

        // when(clinicRepository.findByClinicId(any(String.class))).thenReturn(new
        // Clinics());

        // when(clinicServiceLayer.clinicIdExists(any(Clinics.class))).thenReturn(true);

        when(clinicRepository.findByClinicId(any(String.class))).thenReturn(new Clinics());

        Boolean actual = clinicServiceLayer.clinicIdExists(clinics);

        assertEquals(false, actual);

        verify(clinicRepository).findByClinicId(any(String.class));
    }

    @BeforeEach
    void setup() {
        this.clinicServiceLayer = new ClinicServiceLayer(this.clinicRepository);
    }

}