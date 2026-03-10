package com.example.foyer.Controllers;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Services.IFoyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foyer")

public class FoyerController {
    private final IFoyerService ifoyerService;

    @PostMapping("/addFoyerBlocs")
    @ResponseBody
    public Foyer addFoyerBloc(@RequestBody Foyer foyer){
        return ifoyerService.addFoyerBlocsAffectation(foyer);
    }


    @GetMapping("/getfoyer/{idFoyer}")
    public Foyer recuperarFoyer(@PathVariable long idFoyer)
    {
        return ifoyerService.retrieveFoyer(idFoyer);
    }

    @PostMapping("/addfoyer")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer)
    {
        return ifoyerService.addFoyer(foyer);
    }

    @DeleteMapping("/deletefoyer/{idFoyer}")
    public void  supprimerFoyer(@PathVariable long idFoyer)
    {
        ifoyerService.removeFoyer(idFoyer);
    }

    @GetMapping("/getallfoyer")
    public List<Foyer> recupererFoyer()
    {
        return ifoyerService.retrieveAllFoyer();
    }

    @PutMapping("/updatefoyer")
    public Foyer MAJFoyer(@RequestBody Foyer foyer){
        return ifoyerService.modifyFoyer(foyer);
    }
}
