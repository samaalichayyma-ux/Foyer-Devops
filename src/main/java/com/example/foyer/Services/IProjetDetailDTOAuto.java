package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDetailDTOAuto;
import com.example.foyer.Entities.ProjetDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProjetDetailDTOAuto {
    @Mapping(target = "desc", source="description")

    public ProjetDetailDTOAuto DTOtoDTO(ProjetDetail projetDetail);
    public ProjetDetailDTOAuto getProjet(Long  id);

}
