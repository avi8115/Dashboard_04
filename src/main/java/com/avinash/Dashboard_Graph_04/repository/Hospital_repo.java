package com.avinash.Dashboard_Graph_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.Dashboard_Graph_04.model.Hospital_model;

public interface Hospital_repo extends JpaRepository<Hospital_model, Long> {
}
