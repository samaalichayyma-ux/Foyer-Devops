package com.example.foyer.Services;

import com.example.foyer.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public void desaffecterFoyerDeUniversite(long idUniversite, long idFoyer);



    public Universite affecterFoyerUniversite(long idUniversite, long idFoyer);
    public List<Universite> retrieveAllUniversite();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long idUniversite);
    public Universite modifyUniversite(Universite universite);

}
