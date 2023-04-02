package com.example.td.DAO;

import com.example.td.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

   //1
   @Query("SELECT e FROM Etudiant e JOIN e.departement d WHERE d.nomdepartement = 'Informatique' ORDER BY e.dateentrée DESC\n")
   List<Etudiant>Etudiants();


   //2
   @Query("SELECT e.nom FROM Etudiant e WHERE e.nom LIKE '%L%' AND e.nom LIKE '%M%'")
   List<String> findEtudiantsWithLAndMInNom();

   //3
   @Query("SELECT d.nomdepartement FROM Etudiant e JOIN e.departement d GROUP BY d.id ORDER BY MIN(e.dateentrée) ASC")
   String findDepartementWithOldestStudent();

   //4
   @Query("SELECT AVG(e.moyenne) FROM Etudiant e")
   Double findAverageMoyenne();



}