package com.example.medicalapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String prénom;
    String ville;
    int telephone;

}
