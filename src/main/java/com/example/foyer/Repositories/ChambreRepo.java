package com.example.foyer.Repositories;

import com.example.foyer.Entities.Chambre;
import com.example.foyer.Entities.TypeChabmbre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    List<Chambre> findByNumeroChambreAndTypeC(long numeroChambre, TypeChabmbre type);

    List<Chambre> findByBlocs_IdBlocAndTypeC(long idBloc, TypeChabmbre type);

    @Query("SELECT c FROM Chambre c WHERE c.typeC=:typeC")
    List<Chambre> findByTypeC(@Param("typeC") TypeChabmbre typeC);


    @Query("SELECT c FROM Chambre c WHERE c.blocs.idBloc = :idBloc")
    List<Chambre> findByBloc(@Param("idBloc") Long idBloc);

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.blocs.idBloc = :idBloc")
    Long countChambresByBloc(@Param("idBloc") Long idBloc);


}
