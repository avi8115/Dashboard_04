package com.avinash.Dashboard_Graph_04.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Its instances represent data that can be stored and retrieved from a relational database.
@Table(name = "doctor")
public class Doctor_model {

    @Id
    private Long id;

    @Column(name = "doctor_name")	
    private String doctorName;

    @Column(name = "date")
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "hospital_name", referencedColumnName = "hospital_name")
    private Hospital_model hospital;

	public Long getId() {
		return id;
	}

	public Hospital_model getHospital() {
		return hospital;
	}

	public void setHospital(Hospital_model hospital) {
		this.hospital = hospital;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
   