package com.example.foyer.Services;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Repositories.BlocRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BlocServiceImpl implements IBlocService {

    private final BlocRepo blocRepo;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepo.findById(idBloc).orElseThrow();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepo.deleteById(idBloc);

    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return  blocRepo.save(bloc);
    }
}
