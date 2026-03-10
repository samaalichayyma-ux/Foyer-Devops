package com.example.foyer.Services;

import com.example.foyer.Entities.Reservation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    List<Reservation> recupererReservationDispo(LocalDate anneeUniversitaire);

    List<Reservation> findReservationsValidesByAnneeQuery(LocalDate annee);

    public Long countRservetionByEtudiantQuery(Long idEtudiant);

    List<Object[]> countRservetionByCinQuery();

    public Reservation affecterReservationEtudiant(Long idReservation, Long idEtudiant);
    public List<Reservation> retrieveAllReservation();
    public Reservation retrieveReservation(Long idReservation);
    public Reservation addReservation(Reservation r);
    public void removeReservation(Long idReservation);
    public Reservation modifyReservation(Reservation reservation);
}
