package com.avinash.Dashboard_Graph_04.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.Dashboard_Graph_04.dto.PatientCountByDate;
import com.avinash.Dashboard_Graph_04.model.Patient_model;
import com.avinash.Dashboard_Graph_04.repository.Patient_repo;

@Service
public class PatientServiceImpl implements Patient_service {

    @Autowired
    private Patient_repo patientRepository;

    @Override
    public List<Patient_model> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient_model> getPatientsByDate(String date) {
        // Parse the date string to LocalDate
        LocalDate parsedDate = LocalDate.parse(date);
        return patientRepository.findByDate(parsedDate);
    }
    
    @Override
    public List<PatientCountByDate> getPatientCountByDate() {
        return patientRepository.countPatientsByDate();
    }
    
    @Override
    public List<PatientCountByDate> getPatientCountByDateFiltered(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findPatientCountByDateRange(startDate, endDate);
    }
    
    @Override
    public List<PatientCountByDate> getPatientCountByDateFiltered(LocalDate startDate, LocalDate endDate, Long hospitalId) {
        return patientRepository.findPatientCountByDateRangeAndHospital(startDate, endDate, hospitalId);
    }

}
