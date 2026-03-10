package com.example.foyer.Services;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Entities.Universite;
import com.example.foyer.Repositories.FoyerRepo;
import com.example.foyer.Repositories.UniversiteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepo universiteRepo;
    private final FoyerRepo foyerRepo;

    @Override
    public void desaffecterFoyerDeUniversite(long idUniversite, long idFoyer){
        Foyer f = foyerRepo.findById(idFoyer).get();
        Universite u = universiteRepo.findById(idUniversite).get();
        u.setFoyer(null);
        universiteRepo.save(u);
    }


    @Override
    public Universite affecterFoyerUniversite(long idUniversite, long idFoyer){
        Foyer f = foyerRepo.findById(idFoyer).get();
        Universite u = universiteRepo.findById(idUniversite).get();
        u.setFoyer(f);
        universiteRepo.save(u);
        return u;
    }

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepo.findById(idUniversite).orElseThrow();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepo.deleteById(idUniversite);

    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return  universiteRepo.save(universite);
    }

}
