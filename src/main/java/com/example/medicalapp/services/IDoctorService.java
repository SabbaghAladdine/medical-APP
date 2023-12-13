package com.example.medicalapp.services;

import com.example.medicalapp.entities.doctor;

import java.util.List;

public interface IDoctorService {

    public doctor createdoctor(doctor a);
    public doctor finddoctorById(int id);
    public List<doctor> findAlldoctors() ;

    public doctor updatedoctor(doctor a);
    public void deletedoctor(int id);
    public List<doctor> findAllBySpeciality(String s);

}
