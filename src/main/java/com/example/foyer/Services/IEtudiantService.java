package com.example.foyer.Services;


import com.example.foyer.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant findEtudiantCin(long cin);

    public List<Etudiant> retrieveAllEtudiant();
    public Etudiant retrieveEtudiant(Long idEtudiant);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long idEtudiant);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
