package it.uniroma3.siw_tornei_01.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw_tornei_01.model.Giocatore;
import it.uniroma3.siw_tornei_01.model.Partita;
import it.uniroma3.siw_tornei_01.model.Squadra;
import it.uniroma3.siw_tornei_01.model.Torneo;
import it.uniroma3.siw_tornei_01.repository.GiocatoreRepository;
import it.uniroma3.siw_tornei_01.repository.PartitaRepository;
import it.uniroma3.siw_tornei_01.repository.SquadraRepository;
import it.uniroma3.siw_tornei_01.repository.TorneoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Fondamentale per permettere a React di chiamare le API
public class ApiController {

    @Autowired private TorneoRepository torneoRepo;
    @Autowired private SquadraRepository squadraRepo;
    @Autowired private PartitaRepository partitaRepo;
    @Autowired private GiocatoreRepository giocatoreRepo;

    @GetMapping("/tornei")
    public Iterable<Torneo> getTornei() {
        return torneoRepo.findAll();
    }

    @GetMapping("/squadre")
    public Iterable<Squadra> getSquadre() {
        return squadraRepo.findAll();
    }

    @GetMapping("/partite")
    public Iterable<Partita> getPartite() {
        return partitaRepo.findAll();
    }

    @GetMapping("/giocatori")
    public Iterable<Giocatore> getGiocatori() {
        return giocatoreRepo.findAll();
    }
}