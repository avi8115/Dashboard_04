package com.avinash.Dashboard_Graph_04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.Dashboard_Graph_04.model.Hospital_model;
import com.avinash.Dashboard_Graph_04.repository.Hospital_repo;

@Service
public class HospitalServiceImpl implements Hospital_service {

    @Autowired
    private Hospital_repo hospitalRepository;

    @Override // This annotation marks the method as overriding the interface method
    public List<Hospital_model> getAllHospitals() {
        return hospitalRepository.findAll();
    }
    
    @Override
    public Hospital_model getHospitalById(Long hospitalId) {
      // Implement logic to retrieve hospital by ID
      // You can use JPA repository methods like findById or findOneById
      return hospitalRepository.findById(hospitalId).orElse(null);
    }

}
