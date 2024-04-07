package com.example.cmd.demo.RepositoryLayer;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cmd.demo.DTOs.Clinics;

public interface ClinicRepository extends JpaRepository<Clinics, BigInteger> {

    @Query(value = "SELECT COUNT(*) FROM clinics", nativeQuery = true)
    BigInteger customcount();

    @Query(value = "SELECT * FROM clinics where clinics.clinicId=:clinicId",nativeQuery = true)
    Clinics findByClinicId(@Param("clinicId") String clinicId);

}
