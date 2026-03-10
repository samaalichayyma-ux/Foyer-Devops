package com.example.foyer.Controllers;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Services.IBlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloc")

public class BlocController {

    private final IBlocService iblocService;


    @GetMapping("/getbloc/{idBloc}")
    public Bloc recuperarBloc(@PathVariable long idBloc)
    {
        return iblocService.retrieveBloc(idBloc);
    }

    @PostMapping("/addbloc")
    public Bloc ajouterBloc(@RequestBody Bloc bloc)
    {
        return iblocService.addBloc(bloc);
    }

    @DeleteMapping("/deletebloc/{idBloc}")
    public void  supprimerBloc(@PathVariable long idBloc)
    {
        iblocService.removeBloc(idBloc);
    }

    @GetMapping("/getallblocs")
    public List<Bloc> recupererBloc()
    {
        return iblocService.retrieveAllBlocs();
    }

    @PutMapping("/updatebloc")
    public Bloc MAJBloc(@RequestBody Bloc bloc){
        return iblocService.modifyBloc(bloc);
    }
}
