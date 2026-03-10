package com.example.foyer.Services;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Entities.Chambre;
import com.example.foyer.Entities.TypeChabmbre;
import com.example.foyer.Repositories.BlocRepo;
import com.example.foyer.Repositories.ChambreRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private final ChambreRepo chambreRepo;
    private final BlocRepo blocRepo;

    public List<Chambre> getChambreByType(TypeChabmbre typeC){
        return chambreRepo.findByTypeC(typeC);
    }

    @Override
    public List<Chambre> findByBlocQuery(Long idBloc) {
        return chambreRepo.findByBloc(idBloc);
    }

    @Override
    public Long countChambresByBlocQuery(Long idBloc) {
        return chambreRepo.countChambresByBloc(idBloc);
    }

    @Transactional
    @Scheduled(cron = "0 */5 * * * *") // toutes les 5 minutes
    public void nbPlacesDisponibleParChambreAnneeEnCours() {

        List<Chambre> chambres = chambreRepo.findAll();

        for (Chambre chambre : chambres) {

            int capacite = switch (chambre.getTypeC()) {
                case SIMPLE -> 1;
                case DOUBLE -> 2;
                case TRIPLE -> 3;
            };
            int occupee = chambre.getReservations().size();

            int disponible = capacite - occupee;

            if (disponible <= 0) {
                log.info("La chambre {} {} est complete",
                        chambre.getTypeC(), chambre.getNumeroChambre());
            } else {
                log.info("Le nombre de place disponible pour la chambre {} {} est {}",
                        chambre.getTypeC(), chambre.getNumeroChambre(), disponible);
            }
        }
    }

    @Transactional
    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepo.findAll();
        int total = chambres.size();

        log.info("Nombre total des chambre: {}", total);

        for (TypeChabmbre type : TypeChabmbre.values()) {

            long count = chambres.stream()
                    .filter(c -> c.getTypeC() == type)
                    .count();

            double pourcentage = (total == 0) ? 0 : (count * 100.0 / total);

            log.info("Le pourcentage des chambres pour le type {} est égale à {}",
                    type, pourcentage);
        }

    }

    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void listeChambresParBloc() {
        log.info("listeChambresParBloc");

        List<Bloc> blocs = blocRepo.findAll();

        if (blocs.isEmpty()) {
            log.warn("Aucun bloc trouvé");
            return;
        }

        for (Bloc bloc : blocs) {

            log.info("Bloc => {} ayant une capacité {}",
                    bloc.getNomBloc(), bloc.getCapaciteBloc());

            if (bloc.getChambre() == null || bloc.getChambre().isEmpty()) {

                log.info("Pas de chambre disponible dans ce bloc");

            } else {

                log.info("La liste des chambres pour ce bloc :");

                bloc.getChambre().forEach(chambre ->
                        log.info("NumChambre: {} type: {}",
                                chambre.getNumeroChambre(),
                                chambre.getTypeC())
                );
            }

            log.info("********************");
        }
    }



    @Override
    public List<Chambre> recupererNumeroChambreAndTypeC(long numeroChambre, TypeChabmbre type) {
        return chambreRepo.findByNumeroChambreAndTypeC(numeroChambre, type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChabmbre type) {
        return chambreRepo.findByBlocs_IdBlocAndTypeC(idBloc, type);
    }

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepo.findById(idChambre).orElseThrow();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepo.deleteById(idChambre);

    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return  chambreRepo.save(chambre);
    }
}
