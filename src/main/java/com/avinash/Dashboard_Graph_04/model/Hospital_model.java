package com.avinash.Dashboard_Graph_04.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //Its instances represent data that can be stored and retrieved from a relational database.
@Table(name = "hospital")
public class Hospital_model {

    @Id
    private Long id;

    @Column(name = "hospital_name")
    private String hospitalName;
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
