package com.example.medicalapp.security.repo;

import com.example.medicalapp.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Integer> {
    public AppUser findByUsername(String u);
}
