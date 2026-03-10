package com.example.foyer.Controllers;

import com.example.foyer.Entities.Reservation;
import com.example.foyer.Services.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")

public class ReservationController {

    private final IReservationService iReservationService;


    @GetMapping("/countReservationByCin")
    public List<Object[]> countReservationByEtudiantByCinQuery()
    {
        return iReservationService.countRservetionByCinQuery();
    }

    @GetMapping("/countReservation/{idEtudiant}")
    public Long countReservationByEtudiant(@PathVariable Long idEtudiant)
    {
        return iReservationService.countRservetionByEtudiantQuery(idEtudiant);
    }


    @GetMapping("/getreservationByAnneQuery/{annee}")
    public List<Reservation> recuperarReservationDispoParAnneQuery(@PathVariable LocalDate annee)
    {
        return iReservationService.findReservationsValidesByAnneeQuery(annee);
    }


    @GetMapping("/getreservationdispo/{anneeUniversitaire}")
    public List<Reservation> recuperarReservationDispoParAnne(@PathVariable LocalDate anneeUniversitaire)
    {
        return iReservationService.recupererReservationDispo(anneeUniversitaire);
    }




    @PutMapping("/afffecterReservation/{idReservation}/{idEtudiant}")
    @ResponseBody
    public Reservation affecterReservationToEtudiant(@PathVariable long idReservation,
                                                     @PathVariable long idEtudiant){
        return iReservationService.affecterReservationEtudiant(idReservation, idEtudiant);

    }



    @GetMapping("/getreservation/{idReservation}")
    public Reservation recuperarReservation(@PathVariable long idReservation)
    {
        return iReservationService.retrieveReservation(idReservation);
    }

    @PostMapping("/addreservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation)
    {
        return iReservationService.addReservation(reservation);
    }

    @DeleteMapping("/deletereservation/{idReservation}")
    public void  supprimerReservation(@PathVariable long idReservation)
    {
        iReservationService.removeReservation(idReservation);
    }

    @GetMapping("/getallreservation")
    public List<Reservation> recupererReservation()
    {
        return iReservationService.retrieveAllReservation();
    }

    @PutMapping("/updatereservation")
    public Reservation MAJReservation(@RequestBody Reservation reservation){
        return iReservationService.modifyReservation(reservation);
    }
}
