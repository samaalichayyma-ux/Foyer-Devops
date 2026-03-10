package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Entities.ProjetDetail;
import com.example.foyer.Repositories.ProjetDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor

public class Mapper implements IMapper {

    private final ProjetDetailRepo projetRepo;

    public ProjetDetailDTO getDetailProjet(Long id) {
        ProjetDetail detail = projetRepo.findById(id).orElseThrow(()->new
                RuntimeException("Details du projet non trouvé"));
        return convertToDo(detail);
    }

    public ProjetDetailDTO convertToDo(ProjetDetail detail) {
        ProjetDetailDTO dto = new ProjetDetailDTO();
        dto.setDescription(detail.getDescription());
        dto.setTechnologie(detail.getTechnologie());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dto.setDateDebut(detail.getDateDebut().format(formatter));

        return dto;
    }


}
