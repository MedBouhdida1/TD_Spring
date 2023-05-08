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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/")

@Controller
@AllArgsConstructor
public class DepartementController {
    @Autowired
    private DepartementRepository departementRepository;




    @GetMapping("/")
    public String home( ){
        return "redirect:/user/get";
    }

    @GetMapping(path = "/user/get")
    public String afficherE(Model model){

        List<Departement>departements=departementRepository.findAll();
        model.addAttribute("departements",departements);
        return "departement";

    }


    @GetMapping("/login")
    private String login(Model model){
        model.addAttribute("username", new String()); // add an empty string to the model for the "username" field
        model.addAttribute("password", new String()); // add an empty string to the model for the "username" field

        return "login";
    }


    @GetMapping("admin/add")
    public String GetAdd(Model model) {
        model.addAttribute("departement", new Departement());
        return "addDepartement";
    }


    @PostMapping("admin/add")
    public String addDep(@ModelAttribute("departement") Departement departement) {
        departementRepository.save(departement);
        return "redirect:/user/get";
    }
    @GetMapping("admin/delete/{Iddepartement}")
    public String delete(@PathVariable Long Iddepartement) {
        departementRepository.deleteById(Iddepartement);
        return "redirect:/user/get";
    }

    @GetMapping("admin/update/{Iddepartement}")
    public String affichedep(@PathVariable Long Iddepartement, Model model) {
        Optional<Departement> departement = departementRepository.findById(Iddepartement);
        if (departement.isPresent()) {
            model.addAttribute("departement", departement.get());
            return "editDepartement";
        }
        return "redirect:/user/get";
    }



}






