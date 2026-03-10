package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDetailDTOAuto;
import com.example.foyer.Entities.ProjetDetail;
import com.example.foyer.Repositories.ProjetDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProjetDetailDTOAutoIml {

    private final ProjetDetailRepo projetDetailRepo;
    private final IProjetDetailDTOAuto iProjetDetailDTOAuto;


    public ProjetDetailDTOAuto getProjet(long  id) {
        ProjetDetail detail = projetDetailRepo.findById(id).get();
        return iProjetDetailDTOAuto.DTOtoDTO(detail);
    }



}
