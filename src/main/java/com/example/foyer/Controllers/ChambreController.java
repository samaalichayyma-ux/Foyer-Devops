package com.example.foyer.Controllers;

import com.example.foyer.Entities.Chambre;
import com.example.foyer.Entities.TypeChabmbre;
import com.example.foyer.Services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Gestion Chambre")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chambre")
public class ChambreController {

    private final IChambreService ichambreService;

    @GetMapping("/CountChambre/{idBloc}")
    public Long getChambreByTypeChambre( @PathVariable Long idBloc)
    {
        return ichambreService.countChambresByBlocQuery(idBloc);
    }

    @GetMapping("/getChambreByType/{typeC}")
    public List<Chambre> getChambreByTypeChambre( @PathVariable TypeChabmbre typeC)
    {
        return ichambreService.getChambreByType(typeC);
    }

    @GetMapping("/getChambreByBlocQuery/{idBloc}")
    public List<Chambre> getChambreByBlocQuery( @PathVariable Long idBloc)
    {
        return ichambreService.findByBlocQuery(idBloc);
    }

    @GetMapping("/getChambreParBloc/{idBloc}/{type}")
    public List<Chambre> recupererchambreParBloc(@PathVariable long idBloc, @PathVariable TypeChabmbre type)
    {
        return ichambreService.getChambresParBlocEtType(idBloc,type);
    }

    @GetMapping("/listChambreparNum/{numeroChambre}/{type}")
    public List<Chambre> recuperarChambreParNum(@PathVariable long numeroChambre, @PathVariable TypeChabmbre type)
    {
        return ichambreService.recupererNumeroChambreAndTypeC(numeroChambre,type);
    }


    @Operation(description = "recuperer toutes les chambre de la base")

    @GetMapping("/getchambre/{idChambre}")
    public Chambre recuperarChambre(@PathVariable long idChambre)
    {
        return ichambreService.retrieveChambre(idChambre);
    }


    @PostMapping("/addchambre")
    public Chambre ajouterChambre(@RequestBody Chambre chambre)
    {
        return ichambreService.addChambre(chambre);
    }

    @DeleteMapping("/deletechambre/{idChambre}")
    public void  supprimerChambre(@PathVariable long idChambre)
    {
        ichambreService.removeChambre(idChambre);
    }

    @GetMapping("/getallchambres")
    public List<Chambre> recupererChambre()
    {
        return ichambreService.retrieveAllChambres();
    }

    @PutMapping("/updatechambre")
    public Chambre MAJChambre(@RequestBody Chambre chambre){
        return ichambreService.modifyChambre(chambre);
    }


}
