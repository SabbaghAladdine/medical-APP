package com.example.medicalapp.services;

import com.example.medicalapp.entities.doctor;
import com.example.medicalapp.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class doctorService implements IDoctorService{

    @Autowired
    DoctorRepo dr;

    @Override
    public doctor createdoctor(doctor a) {
        return dr.save(a);
    }

    @Override
    public doctor finddoctorById(int id) {
        return dr.findById(id).get();
    }

    @Override
    public List<doctor> findAlldoctors() {
        return dr.findAll();
    }

    @Override
    public doctor updatedoctor(doctor a) {
        return dr.save(a);
    }

    @Override
    public void deletedoctor(int id) {
        dr.deleteById(id);
    }

    @Override
    public List<doctor> findAllBySpeciality(String s) {
        return dr.findAllBySpecialite(s);
    }

}
