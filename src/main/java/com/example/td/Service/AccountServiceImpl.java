package com.example.td.Service;

import com.example.td.DAO.AppRoleRepository;
import com.example.td.DAO.AppUserRepository;
import com.example.td.Models.AppRole;
import com.example.td.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AccountServiceImpl implements AccountService{


    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository userRepository;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmedPassword) {
        AppUser user = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(password)
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
