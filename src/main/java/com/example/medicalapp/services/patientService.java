package com.example.medicalapp.services;

import com.example.medicalapp.entities.patient;
import com.example.medicalapp.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class patientService implements IPatientService{

    @Autowired
    PatientRepo pr;

    @Override
    public patient createpatient(patient a) {
        return pr.save(a);
    }

    @Override
    public patient findpatientById(int id) {
        return pr.findById(id).get();
    }

    @Override
    public List<patient> findAllpatients() {
        return pr.findAll();
    }

    @Override
    public patient updatepatient(patient a) {
        return pr.save(a);
    }

    @Override
    public void deletepatient(int id) {
        pr.deleteById(id);
    }

}
