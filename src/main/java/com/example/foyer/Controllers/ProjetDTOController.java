package com.example.foyer.Controllers;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Services.IMapper;
import com.example.foyer.Services.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Gestion ProjetDTO")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projet")

public class ProjetDTOController {

    private final IMapper iMapper;

    @Operation(description = "recuperer toutes les details de projet")
    @GetMapping("/{id}/details")
    public ProjetDetailDTO getDetails(@PathVariable long id){
        return iMapper.getDetailProjet(id);
    }



}
