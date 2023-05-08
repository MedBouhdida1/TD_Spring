package com.example.td.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numE;
    @NonNull
    private String nom;
    @NonNull
    private int niveau;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateentrée;

//    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_spécialité")
    @JsonIgnoreProperties("etudiants")
    private Specialite specialite;

//    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_departement")
    @JsonIgnoreProperties("etudiants")
    private Departement departement;
    @NonNull
    private float moyenne;

}
