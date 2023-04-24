package com.example.td.Controllers;


import com.example.td.DAO.EtudiantRepository;
import com.example.td.Models.Etudiant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;



    @GetMapping("/GetE")
    @JsonBackReference // to avoid infinite recursion
    public List<Etudiant> afficherE(){
        return etudiantRepository.findAll();
    }

    @GetMapping("/GetEtudiant/{id}")
    public Etudiant afficherOne(@PathVariable("id") Long id){
        return etudiantRepository.findById(id).get();
    }

    @PostMapping("AddE")
    public Etudiant ajouterE(@RequestBody Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    @DeleteMapping("/DeleteE/{id}")
    public String deleteE(@PathVariable("id") Long id){
        etudiantRepository.deleteById(id);
        return "deleted";
    }
    //update
    @PutMapping("/UpdateE/{id}")
    public Etudiant updateE(@PathVariable("id") Long id,@RequestBody Etudiant etudiant){
        etudiant.setNumE(id);
        return etudiantRepository.save(etudiant);
    }
}
