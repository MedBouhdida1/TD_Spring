package com.example.td.Controllers;


import com.example.td.DAO.DepartementRepository;
import com.example.td.DAO.EtudiantRepository;
import com.example.td.Models.Departement;
import com.example.td.Models.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/departement")

@Controller
@AllArgsConstructor
public class DepartementController {
    @Autowired
    private DepartementRepository departementRepository;



    @GetMapping(path = "/get")
    public String afficherE(Model model){


        model.addAttribute("test","hello");
        return "message";

    }





}
