package com.example.medicalapp.security.service;

import com.example.medicalapp.security.entities.AppRole;
import com.example.medicalapp.security.entities.AppUser;
import com.example.medicalapp.security.repo.AppRoleRepo;
import com.example.medicalapp.security.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAuthentication implements IServiceAuthentication {

    @Autowired
    AppRoleRepo arp;
    @Autowired
    AppUserRepo aur;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public AppUser createAppUser(AppUser appUser) throws RuntimeException{
        if (!(aur.findByUsername(appUser.getUsername())==null)){
            throw new RuntimeException("User Exists");
        }
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        return aur.save(appUser);
    }

    @Override
    public AppRole createAppRole(AppRole appRole) throws RuntimeException {
        if (!(arp.findByRole(appRole.getRole())==null)){
            throw new RuntimeException("Role Exists");
        }
        return arp.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser u=aur.findByUsername(username);
        AppRole r = arp.findByRole(role);
        List<AppRole>ur = u.getRole();
        ur.add(r);
        u.setRole(ur);
        aur.save(u);
    }

    @Override
    public void removeRoleToUser(String username, String role) {
        AppUser u=aur.findByUsername(username);
        AppRole r = arp.findByRole(role);
        List<AppRole>ur = u.getRole();
        ur.remove(r);
        u.setRole(ur);
        aur.save(u);
    }

    @Override
    public AppUser LoadUserByUserName(String username) {
        return aur.findByUsername(username);
    }


}
