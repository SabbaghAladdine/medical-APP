package com.example.medicalapp.Controllers;

import com.example.medicalapp.entities.doctor;
import com.example.medicalapp.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class doctorController {

    @Autowired
    IDoctorService ds;

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/find/{id}")
    public ResponseEntity<doctor> findDoctor(@PathVariable("id") int id){
        doctor d = ds.finddoctorById(id);
        if (d==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(d);
        }
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<doctor>addDoctor(@RequestBody doctor d){
        doctor dr = ds.createdoctor(d);
        return ResponseEntity.ok(dr);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<doctor>updateDoctor(@RequestBody doctor d){
        doctor dr = ds.updatedoctor(d);
        return ResponseEntity.ok(dr);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void  deleteDoctor(@PathVariable("id") int id){
        ds.deletedoctor(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/all/speciality/{string}")
    public ResponseEntity<List<doctor>> findAllBySpeciality(@PathVariable("string") String s){
        return ResponseEntity.ok(ds.findAllBySpeciality(s));
    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<doctor>> findAll(){
        return ResponseEntity.ok(ds.findAlldoctors());
    }

}
