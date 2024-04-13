package com.avinash.Dashboard_Graph_04.service;

import java.util.List;

import com.avinash.Dashboard_Graph_04.model.Hospital_model;



public interface Hospital_service {

    List<Hospital_model> getAllHospitals();

	Hospital_model getHospitalById(Long hospitalId);
}
