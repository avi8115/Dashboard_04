//package com.avinash.Dashboard_Graph_04.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.avinash.Dashboard_Graph_04.model.Patient_model;
//import com.avinash.Dashboard_Graph_04.service.Patient_service;
//
//@RestController
//public class Patient_controller {
//
//    @Autowired
//    private Patient_service patientService;
//
//    @GetMapping("/patients") // Endpoint for retrieving all patients
//    public List<Patient_model> getAllPatients() {
//        return patientService.getAllPatients();
//    }
//
//    @GetMapping("/patients/{date}") // Endpoint for retrieving patients by date
//    public List<Patient_model> getPatientsByDate(@PathVariable String date) {
//        return patientService.getPatientsByDate(date);
//    }
//}
