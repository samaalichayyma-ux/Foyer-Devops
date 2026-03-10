package com.example.foyer.Services;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Repositories.BlocRepo;
import com.example.foyer.Repositories.FoyerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepo foyerRepo;
    private final BlocRepo blocRepo;


    @Override
    public Foyer addFoyerBlocsAffectation(Foyer f){
        Foyer foyer=foyerRepo.save(f);
        foyer.getBloc().forEach(
                bloc->{
            bloc.setFoyer(foyer);
            blocRepo.save(bloc);
        });
        return foyer;
    }

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepo.findById(idFoyer).orElseThrow();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepo.deleteById(idFoyer);

    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return  foyerRepo.save(foyer);
    }
}
