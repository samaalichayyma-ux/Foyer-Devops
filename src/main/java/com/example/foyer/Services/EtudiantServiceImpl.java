package com.example.foyer.Services;

import com.example.foyer.Entities.Etudiant;
import com.example.foyer.Entities.Reservation;
import com.example.foyer.Repositories.EtudiantRepo;
import com.example.foyer.Repositories.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;
    private final ReservationRepo reservationRepo;


    @Override
    public Etudiant findEtudiantCin(long cin) {
        return etudiantRepo.findByCin(cin);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElseThrow();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);

    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return  etudiantRepo.save(etudiant);
    }
}
