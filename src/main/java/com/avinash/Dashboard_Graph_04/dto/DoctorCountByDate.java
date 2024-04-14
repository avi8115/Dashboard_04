package com.avinash.Dashboard_Graph_04.dto;

import java.time.LocalDate;

public class DoctorCountByDate {

    private LocalDate date;
    private String hospitalName;
    private Long count;

    // Constructor, getters, and setters

    public DoctorCountByDate(String hospitalName, Long count) {
        this.hospitalName = hospitalName;
        this.count = count;
    }
    
    public DoctorCountByDate(LocalDate date, Long count) {
        this.date = date;
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	
}
