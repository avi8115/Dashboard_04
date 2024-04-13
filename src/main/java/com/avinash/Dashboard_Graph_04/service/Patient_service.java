package com.avinash.Dashboard_Graph_04.service;

import java.time.LocalDate;
import java.util.List;

import com.avinash.Dashboard_Graph_04.dto.PatientCountByDate;
import com.avinash.Dashboard_Graph_04.model.Patient_model;

public interface Patient_service {

    List<Patient_model> getAllPatients();

    List<Patient_model> getPatientsByDate(String date);
    
    List<PatientCountByDate> getPatientCountByDate(); 
    
    List<PatientCountByDate> getPatientCountByDateFiltered(LocalDate startDate, LocalDate endDate);
    
    List<PatientCountByDate> getPatientCountByDateFiltered(LocalDate startDate, LocalDate endDate, Long hospitalId);

}
