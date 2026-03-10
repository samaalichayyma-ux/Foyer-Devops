package com.example.foyer.Controllers;

import com.example.foyer.Entities.Etudiant;
import com.example.foyer.Services.IEtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/etudiant")

public class EtudiantController {
    private final IEtudiantService ietudiantService;

    @GetMapping("/getParcin/{cin}")
    public Etudiant finfEtudiantCin(@PathVariable long cin)
    {
        return ietudiantService.findEtudiantCin(cin);
    }




    @GetMapping("/getetudiant/{idEtudiant}")
    public Etudiant recuperarEtudiant(@PathVariable long idEtudiant)
    {
        return ietudiantService.retrieveEtudiant(idEtudiant);
    }

    @PostMapping("/addetudiant")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant)
    {
        return ietudiantService.addEtudiant(etudiant);
    }

    @DeleteMapping("/deleteetudiant/{idEtudiant}")
    public void  supprimerEtudiant(@PathVariable long idEtudiant)
    {
        ietudiantService.removeEtudiant(idEtudiant);
    }

    @GetMapping("/getalletudiants")
    public List<Etudiant> recupererEtudiant()
    {
        return ietudiantService.retrieveAllEtudiant();
    }

    @PutMapping("/updateetudiant")
    public Etudiant MAJEtudiant(@RequestBody Etudiant etudiant){
        return ietudiantService.modifyEtudiant(etudiant);
    }

}
