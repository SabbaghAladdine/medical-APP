package com.example.medicalapp;

import com.example.medicalapp.entities.patient;
import com.example.medicalapp.repo.PatientRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    private com.example.medicalapp.services.patientService patientService;

    @Mock
    private PatientRepo patientRepository;

    @Test
    public void testCreatePatient() {

        patient patient = new patient(0,"ala","sab","msaken",21557788);
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        patient createdPatient = patientService.createpatient(patient);
        assertNotNull(createdPatient);
        assertEquals(patient.getNom(),"ala");
    }

}
