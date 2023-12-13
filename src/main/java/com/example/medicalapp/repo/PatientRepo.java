package com.example.medicalapp.repo;

import com.example.medicalapp.entities.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepo extends JpaRepository<patient,Integer> {
}
