//package com.avinash.Dashboard_Graph_04.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.avinash.Dashboard_Graph_04.model.Doctor_model;
//import com.avinash.Dashboard_Graph_04.service.Doctor_service;
//
//@RestController
//public class Doctor_controller {
//
//    @Autowired
//    private Doctor_service doctorService;
//
//    @GetMapping("/doctors") // Endpoint for retrieving all doctors
//    public List<Doctor_model> getAllDoctors() {
//        return doctorService.getAllDoctors();
//    }
//
//    @GetMapping("/doctors/{date}") // Endpoint for retrieving doctors by date
//    public List<Doctor_model> getDoctorsByDate(@PathVariable String date) {
//        return doctorService.getDoctorsByDate(date);
//    }
//}
