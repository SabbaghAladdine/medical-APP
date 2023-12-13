package com.example.medicalapp.security.repo;

import com.example.medicalapp.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole,Integer> {
    public AppRole findByRole(String r);
}
