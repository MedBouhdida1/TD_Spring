package com.example.td.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String libelle;
    @JsonIgnore
    @OneToMany(mappedBy = "specialite")
    private List<Etudiant>Etudiants;



}
