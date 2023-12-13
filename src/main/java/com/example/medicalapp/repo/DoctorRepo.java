package com.example.medicalapp.repo;

import com.example.medicalapp.entities.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<doctor,Integer> {
    public List<doctor> findAllBySpecialite(String s);
}
