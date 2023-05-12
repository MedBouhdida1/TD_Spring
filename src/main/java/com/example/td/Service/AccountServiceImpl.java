package com.example.td.Service;

import com.example.td.DAO.AppRoleRepository;
import com.example.td.DAO.AppUserRepository;
import com.example.td.Models.AppRole;
import com.example.td.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class AccountServiceImpl implements AccountService{


    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    PasswordEncoder passwordEncoder=passwordEncoder();

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository userRepository;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmedPassword) {

        AppUser appUser=userRepository.findByUsername(username);
        if(appUser!=null)throw new RuntimeException("this user already exist");
        if(!password.equals(confirmedPassword))throw new RuntimeException("password not match");
        AppUser user = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        return user;
    }

    @Override
    public AppRole addNewRole(String role) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String role) {

    }

    @Override
    public void removeRoleFromUser(String username, String role) {

    }
}
