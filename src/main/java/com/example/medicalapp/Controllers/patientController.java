package com.example.medicalapp.Controllers;

import com.example.medicalapp.entities.patient;
import com.example.medicalapp.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class patientController {

    @Autowired
    IPatientService ds;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/find")
    public ResponseEntity<List<patient>> findAllPatients(){
        List<patient> d = ds.findAllpatients();
            return ResponseEntity.ok(d);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/find/{id}")
    public ResponseEntity<patient> findPatient(@PathVariable("id") int id){
        patient d = ds.findpatientById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<patient>addPatient(@RequestBody patient d){
        patient dr = ds.createpatient(d);
        return ResponseEntity.ok(dr);
    }
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<patient>updatePatient(@RequestBody patient d){
        patient dr = ds.updatepatient(d);
        return ResponseEntity.ok(dr);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void  deletePatient(@PathVariable("id") int id){
        ds.deletepatient(id);
    }


}
