package com.avinash.Dashboard_Graph_04.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Its instances represent data that can be stored and retrieved from a relational database.
@Table(name = "patient")
public class Patient_model {

    @Id
    private Long id;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "date")
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "hospital_name", referencedColumnName = "hospital_name")
    private Hospital_model hospital;

    // Getters and setters

    public Hospital_model getHospital() {
		return hospital;
	}

	public void setHospital(Hospital_model hospital) {
		this.hospital = hospital;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
