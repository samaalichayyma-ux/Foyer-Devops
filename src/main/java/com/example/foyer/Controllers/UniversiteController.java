package com.example.foyer.Controllers;

import com.example.foyer.Entities.Universite;
import com.example.foyer.Services.IUniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/universite")

public class UniversiteController {

    private final IUniversiteService iuniversiteService;

    @PutMapping("/desaffectFoyerToUniversite/{idUniversite}/{idFoyer}")
    public void  desaffectFoyerToUniversite(@PathVariable long idUniversite,
                                            @PathVariable long idFoyer) {
        iuniversiteService.desaffecterFoyerDeUniversite(idUniversite, idFoyer);
    }


    @PutMapping("/affectFoyerToUniversite/{idUniversite}/{idFoyer}")
    public Universite affectFoyerToUniversite(@PathVariable long idUniversite,
                                              @PathVariable long idFoyer) {
        return  iuniversiteService.affecterFoyerUniversite(idUniversite, idFoyer);
    }


    @GetMapping("/getuniversite/{idUniversite}")
    public Universite recuperarUniversite(@PathVariable long idUniversite)
    {
        return iuniversiteService.retrieveUniversite(idUniversite);
    }

    @PostMapping("/adduniversite")
    public Universite ajouterUniversite(@RequestBody Universite universite)
    {
        return iuniversiteService.addUniversite(universite);
    }

    @DeleteMapping("/deleteuniversite/{idUniversite}")
    public void  supprimerUniversite(@PathVariable long idUniversite)
    {
        iuniversiteService.removeUniversite(idUniversite);
    }

    @GetMapping("/getalluniversite")
    public List<Universite> recupererUniversite()
    {
        return iuniversiteService.retrieveAllUniversite();
    }

    @PutMapping("/updateuniversite")
    public Universite MAJUniversite(@RequestBody Universite universite){
        return iuniversiteService.modifyUniversite(universite);
    }
}
