package com.example.foyer.Repositories;

import com.example.foyer.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {

    List<Reservation> findByEstValideTrueAndAnneeUniversitaireGreaterThan(LocalDate anneeUniversitaire);

    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :annee AND r.estValide = true")
    List<Reservation> findReservationsValidesByAnnee(@Param("annee") LocalDate annee);

    //1
    @Query("SELECT COUNT(r) from Reservation r join r.etudiants Etudiant where Etudiant.idEtudiant =:idEtudiant")
    Long countRservetionByEtudiant(@Param("idEtudiant") Long idEtudiant);

    //2
    @Query("SELECT e.cin, COUNT(r) from Reservation r join r.etudiants e GROUP BY e.cin")
    List<Object[]> countRservetionByCin();

}
//1 . calculer nbr reservation par etudiant
//2 . calculer le nbr de reser pour chaque etudiant en regroupant les etudiants par cin