package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Entities.ProjetDetail;

public interface IMapper {
    public ProjetDetailDTO getDetailProjet(Long id);
    public ProjetDetailDTO convertToDo(ProjetDetail detail);
}
