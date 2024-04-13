//package com.avinash.Dashboard_Graph_04.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.avinash.Dashboard_Graph_04.model.Hospital_model;
//import com.avinash.Dashboard_Graph_04.service.Hospital_service;
//
//@RestController
//public class Hospital_controller {
//
//    @Autowired
//    private Hospital_service hospitalService;
//
//    @GetMapping("/")
//    public String getAllHospitals(Model model) {
//        List<Hospital_model> hospitals = hospitalService.getAllHospitals();
//        model.addAttribute("hospitals", hospitals); // Add hospitals to model
//        return "/index"; // Replace with your actual template name
//    }
//
//}
