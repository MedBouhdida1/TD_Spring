package com.example.td.DAO;

import com.example.td.Models.Departement;
import com.example.td.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

   //1
   @Query("SELECT e FROM Etudiant e JOIN e.departement d WHERE d.nomdepartement = 'Informatique' ORDER BY e.dateentrée DESC\n")
   List<Etudiant>Etudiants();


   //2
   @Query("SELECT e.nom FROM Etudiant e WHERE e.nom LIKE '%L%' AND e.nom LIKE '%M%'")
   List<String> aa();


   //or
   List<Etudiant>findByNomContainingAndNomContaining(String x,String y);

   //3
   @Query("select distinct e.departement from Etudiant e where e.dateentrée =(select min(e.dateentrée))")
   List<Departement>deprt();

   //4
   @Query("SELECT AVG(e.moyenne) FROM Etudiant e")
   Double findAverageMoyenne();


//   @RestResource(path="Q6")
//   @Query("SELECT d.nomdepartement, COUNT(d.Etudiants) FROM Departement d GROUP BY d")
//   Object[] nbDept();





}