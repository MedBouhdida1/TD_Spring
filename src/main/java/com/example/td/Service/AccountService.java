package com.example.td.Service;

import com.example.td.Models.AppRole;
import com.example.td.Models.AppUser;

public interface AccountService {


    AppUser addNewUser(String username,String password,String email,String confirmedPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username,String role);
    void removeRoleFromUser(String username,String role);
}
