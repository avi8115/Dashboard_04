package com.avinash.Dashboard_Graph_04.service;

import java.time.LocalDate;
import java.util.List;

import com.avinash.Dashboard_Graph_04.dto.DoctorCountByDate;
import com.avinash.Dashboard_Graph_04.model.Doctor_model;

public interface Doctor_service {

    List<Doctor_model> getAllDoctors();

    List<Doctor_model> getDoctorsByDate(String date);
    
    List<DoctorCountByDate> getDoctorCountByDate(); 
    
    List<DoctorCountByDate> getDoctorCountByDateFiltered(LocalDate startDate, LocalDate endDate);
    
    List<DoctorCountByDate> getDoctorCountByDateFiltered(LocalDate startDate, LocalDate endDate, Long hospitalId);


}
