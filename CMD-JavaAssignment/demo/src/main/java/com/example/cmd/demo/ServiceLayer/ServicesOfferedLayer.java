package com.example.cmd.demo.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cmd.demo.DTOs.Services;
import com.example.cmd.demo.Interface.ServiceOfferedInterface;
import com.example.cmd.demo.RepositoryLayer.ServiceRepository;

@Service
public class ServicesOfferedLayer implements ServiceOfferedInterface {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void createServices(Services services) {
        serviceRepository.save(services);
    }

}
