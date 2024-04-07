package com.example.cmd.demo.RepositoryLayer;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cmd.demo.DTOs.Services;


public interface ServiceRepository extends JpaRepository<Services, BigInteger> {

}
