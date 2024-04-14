package com.avinash.Dashboard_Graph_04.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avinash.Dashboard_Graph_04.dto.DoctorCountByDate;
import com.avinash.Dashboard_Graph_04.dto.PatientCountByDate;
import com.avinash.Dashboard_Graph_04.model.Hospital_model;
import com.avinash.Dashboard_Graph_04.service.Doctor_service;
import com.avinash.Dashboard_Graph_04.service.Hospital_service;
import com.avinash.Dashboard_Graph_04.service.Patient_service;

@Controller
public class Home_controller {

	@Autowired
	private Patient_service patientService;

	@Autowired
	private Doctor_service doctorService;

	@Autowired	
	private Hospital_service hospitalService;
	
	@GetMapping("/hospital")
	public String hospital(Model model, @RequestParam(required = false) Long hospitalId) {
	  // Fetch hospitals
	  List<Hospital_model> hospitals = hospitalService.getAllHospitals();
	  model.addAttribute("hospitals", hospitals);
	  return "hospital";
	}

	@GetMapping("/api/patients/count-by-date")
	public ResponseEntity<List<PatientCountByDate>> getPatientCountByDateFiltered(
	        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
	        @RequestParam(required = false) Long hospitalId) { // Optional hospitalId parameter
	    List<PatientCountByDate> data;
	    if (hospitalId != null) {
	        // Filter by hospitalId if provided
	        data = patientService.getPatientCountByDateFiltered(startDate, endDate, hospitalId);
	    } else if (startDate != null && endDate != null) {
	        // Return data for all hospitals if hospitalId is not provided
	        data = patientService.getPatientCountByDateFiltered(startDate, endDate);
	    } else {
	        // Return all data if no dates are provided
	        data = patientService.getPatientCountByDate();
	    }
	    return ResponseEntity.ok(data);
	}
	
	// Similar endpoint for doctor data (replace Patient with Doctor)
	@GetMapping("/api/doctors/count-by-date")
	public ResponseEntity<List<DoctorCountByDate>> getDoctorCountByDateFiltered(
	        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
	        @RequestParam(required = false) Long hospitalId) { // Optional hospitalId parameter
	    List<DoctorCountByDate> data;
	    if (hospitalId != null) {
	        // Filter by hospitalId if provided
	        data = doctorService.getDoctorCountByDateFiltered(startDate, endDate, hospitalId);
	    } else if (startDate != null && endDate != null) {
	        // Return data for all hospitals if hospitalId is not provided
	        data = doctorService.getDoctorCountByDateFiltered(startDate, endDate);
	    } else {
	        // Return all data if no dates are provided
	        data = doctorService.getDoctorCountByDate();
	    }
	    return ResponseEntity.ok(data);
	}

	@PostMapping("/process-data")
	public String processData(Model model,
			@RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
			@RequestParam(required = true) String mode) {
		// Fetch and filter data based on mode, date range, and hospital
		if ("Patient".equals(mode)) {
			List<PatientCountByDate> patientData = patientService.getPatientCountByDateFiltered(startDate, endDate);
			model.addAttribute("patientData", patientData);
		} else if ("Doctor".equals(mode)) {
			List<DoctorCountByDate> doctorData = doctorService.getDoctorCountByDateFiltered(startDate, endDate);
			model.addAttribute("doctorData", doctorData);
		}
		model.addAttribute("selectedStartDate", startDate);
		model.addAttribute("selectedEndDate", endDate);
		model.addAttribute("selectedMode", mode);

		return "index";

	}
	
	@PostMapping("/process-hospital-data")
	public String processHospitalData(Model model,
	        @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	        @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
	        @RequestParam(required = true) String mode,
	        @RequestParam(required = false) Long hospitalId) {
	    
	    // Fetch and filter data based on mode, date range, and hospital
		if ("Patient".equals(mode)) {
		    List<PatientCountByDate> patientData;
		    if (hospitalId != null) {
		        patientData = patientService.getPatientCountByDateFiltered(startDate, endDate, hospitalId);
		    } else {
		        patientData = patientService.getPatientCountByDateFiltered(startDate, endDate);
		    }
		    model.addAttribute("patientData", patientData);
		} else if ("Doctor".equals(mode)) {
		    List<DoctorCountByDate> doctorData;
		    if (hospitalId != null) {
		        doctorData = doctorService.getDoctorCountByDateFiltered(startDate, endDate, hospitalId);
		    } else {
		        doctorData = doctorService.getDoctorCountByDateFiltered(startDate, endDate);
		    }
		    model.addAttribute("doctorData", doctorData);
		}


	    // Add attributes to the model to maintain state
	    model.addAttribute("selectedStartDate", startDate);
	    model.addAttribute("selectedEndDate", endDate);
	    model.addAttribute("selectedMode", mode);
	    model.addAttribute("selectedHospitalId", hospitalId);
	    
	    // Return the hospital view
	    return "hospital";
	}

	
	
}