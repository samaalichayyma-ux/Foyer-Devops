package com.example.foyer.Services;

import com.example.foyer.Entities.Etudiant;
import com.example.foyer.Entities.Reservation;
import com.example.foyer.Repositories.EtudiantRepo;
import com.example.foyer.Repositories.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepo reservationRepo;
    private final EtudiantRepo etudiantRepo;

    @Override
    public List<Reservation> recupererReservationDispo(LocalDate anneeUniversitaire) {
        return reservationRepo.findByEstValideTrueAndAnneeUniversitaireGreaterThan(anneeUniversitaire);
    }

    @Override
    public List<Reservation> findReservationsValidesByAnneeQuery(LocalDate annee) {
        return reservationRepo.findReservationsValidesByAnnee(annee);
    }

    @Override
    public Long countRservetionByEtudiantQuery(Long idEtudiant) {
        return reservationRepo.countRservetionByEtudiant(idEtudiant);
    }

    @Override
    public List<Object[]> countRservetionByCinQuery() {
        return reservationRepo.countRservetionByCin();
    }

    @Override
    public Reservation affecterReservationEtudiant(Long idReservation, Long idEtudiant){
        Reservation reservation = reservationRepo.findById(idReservation).get();
        Etudiant etudiant = etudiantRepo.findById(idEtudiant).get();
        List<Etudiant> etuMAJ = new ArrayList<>();

        if(reservation.getEtudiants()!=null){
            etuMAJ=reservation.getEtudiants();
        }
        etuMAJ.add(etudiant);
        reservation.setEtudiants(etuMAJ);
        reservationRepo.save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).orElseThrow();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepo.deleteById(idReservation);

    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return  reservationRepo.save(reservation);
    }
}
