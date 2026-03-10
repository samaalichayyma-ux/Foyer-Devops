package com.example.foyer.Services;

import com.example.foyer.Entities.Foyer;

import java.util.List;

public interface IFoyerService {

    public Foyer addFoyerBlocsAffectation(Foyer f);

    public List<Foyer> retrieveAllFoyer();
    public Foyer retrieveFoyer(Long idFoyer);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long idFoyer);
    public Foyer modifyFoyer(Foyer foyer);
}
