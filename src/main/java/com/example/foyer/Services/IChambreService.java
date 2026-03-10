package com.example.foyer.Services;

import com.example.foyer.Entities.Chambre;
import com.example.foyer.Entities.TypeChabmbre;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IChambreService {
    void nbPlacesDisponibleParChambreAnneeEnCours();
    void pourcentageChambreParTypeChambre();

    void listeChambresParBloc();

    List<Chambre> recupererNumeroChambreAndTypeC(long numeroChambre, TypeChabmbre type);
    List<Chambre> getChambresParBlocEtType (long idBloc, TypeChabmbre type);


    List<Chambre> getChambreByType(TypeChabmbre typeC);


    List<Chambre> findByBlocQuery(Long idBloc);

    public Long countChambresByBlocQuery(Long idBloc);

    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long idChambre);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long idChambre);
    public Chambre modifyChambre(Chambre chambre);
}
