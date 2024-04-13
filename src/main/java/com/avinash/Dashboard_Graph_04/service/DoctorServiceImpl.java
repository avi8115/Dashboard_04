package com.avinash.Dashboard_Graph_04.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.Dashboard_Graph_04.dto.DoctorCountByDate;
import com.avinash.Dashboard_Graph_04.model.Doctor_model;
import com.avinash.Dashboard_Graph_04.repository.Doctor_repo;

@Service
public class DoctorServiceImpl implements Doctor_service {

    @Autowired
    private Doctor_repo doctorRepository;

    @Override
    public List<Doctor_model> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor_model> getDoctorsByDate(String date) {
        // Parse the date string to LocalDate
        LocalDate parsedDate = LocalDate.parse(date);
        return doctorRepository.findByDate(parsedDate);
    }
    
    @Override
    public List<DoctorCountByDate> getDoctorCountByDate() {
        return doctorRepository.countDoctorsByDate();
    }
    
    @Override
    public List<DoctorCountByDate> getDoctorCountByDateFiltered(LocalDate startDate, LocalDate endDate) {
        return doctorRepository.findDoctorCountByDateRange(startDate, endDate);
    }
    
    @Override
    public List<DoctorCountByDate> getDoctorCountByDateFiltered(LocalDate startDate, LocalDate endDate, Long hospitalId) {
        // Implementation to fetch doctor count filtered by date range and hospitalId
        // You will need to add a new method in your Doctor_repo to support this query
        return doctorRepository.findDoctorCountByDateRangeAndHospital(startDate, endDate, hospitalId);
    }
    
}
