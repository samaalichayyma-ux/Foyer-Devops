package com.example.foyer.Controllers;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.DTO.ProjetDetailDTOAuto;
import com.example.foyer.Entities.ProjetDetail;
import com.example.foyer.Services.IMapper;
import com.example.foyer.Services.IProjetDetailDTOAuto;
import com.example.foyer.Services.ProjetDetailDTOAutoIml;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/AutoPr")

public class ProjetAutoController {

    private final ProjetDetailDTOAutoIml projetDetailDTOAutoIml;

    @Operation(description = "recuperer toutes les details de projet")
    @GetMapping("/{id}/details")
    public ProjetDetailDTOAuto getDetails(@PathVariable long id){
        return projetDetailDTOAutoIml.getProjet(id);
    }

}
