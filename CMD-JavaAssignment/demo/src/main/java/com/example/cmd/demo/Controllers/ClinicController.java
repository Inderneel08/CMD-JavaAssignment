package com.example.cmd.demo.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmd.demo.DTOs.Clinics;
import com.example.cmd.demo.DTOs.Services;
import com.example.cmd.demo.ServiceLayer.ClinicServiceLayer;
import com.example.cmd.demo.ServiceLayer.ServicesOfferedLayer;
import java.math.BigInteger;

@RestController
public class ClinicController {

    @Autowired
    private ClinicServiceLayer clinicServiceLayer;

    @Autowired
    private ServicesOfferedLayer servicesOfferedLayer;

    @PostMapping("/create-clinic")
    public ResponseEntity<?> createclinic(@RequestBody Map<String, Object> clinic) {

        Clinics clinics = new Clinics();

        Map<String, String> clinicData = (Map<String, String>) clinic.get("clinic");

        clinics.setClinicId(clinicData.get("clinicId"));
        clinics.setClinicName(clinicData.get("clinicName"));
        clinics.setBuisnessName(clinicData.get("buisnessName"));
        clinics.setStreetAddress(clinicData.get("streetAddress"));
        clinics.setCity(clinicData.get("city"));
        clinics.setState(clinicData.get("state"));
        clinics.setCountry(clinicData.get("country"));
        clinics.setZipCode(clinicData.get("zipCode"));
        clinics.setLatitude(Double.valueOf(clinicData.get("latitude")));
        clinics.setLongitude(Double.valueOf(clinicData.get("longitude")));
        clinics.setDateCreated(new Date(System.currentTimeMillis()));

        if (clinicServiceLayer.clinicIdExists(clinics)) {
            List<Map<String, String>> servicesData = (List<Map<String, String>>) clinic.get("services");

            for (Map<String, String> serviceData : servicesData) {
                Services services = new Services();

                services.setServiceTag(clinicServiceLayer.getTotalClinicsCount().add(BigInteger.ONE));
                services.setAvgPrice(Integer.valueOf(serviceData.get("avgPrice")));
                services.setServiceCode(serviceData.get("serviceCode"));
                services.setServiceName(serviceData.get("serviceName"));
                services.setServiceDescription(serviceData.get("serviceDescription"));
                services.setIsActive(Integer.valueOf(serviceData.get("isActive")));
                servicesOfferedLayer.createServices(services);
            }

            clinicServiceLayer.createclinic(clinics);

            return (ResponseEntity.ok().body("Clinic with all its services have been installed..."));
        }

        return (ResponseEntity.badRequest().body("Clinic with this clinic id already exists."));
    }
}
