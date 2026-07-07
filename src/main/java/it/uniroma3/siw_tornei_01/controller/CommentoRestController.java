package it.uniroma3.siw_tornei_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw_tornei_01.model.Commento;
import it.uniroma3.siw_tornei_01.model.Partita;
import it.uniroma3.siw_tornei_01.repository.CommentoRepository;
import it.uniroma3.siw_tornei_01.repository.PartitaRepository;

@RestController
@RequestMapping("/api/commenti")
public class CommentoRestController {

    @Autowired private CommentoRepository commentoRepository;
    @Autowired private PartitaRepository partitaRepository;

    
    @GetMapping("/{partitaId}")
    public List<Commento> getCommenti(@PathVariable Long partitaId) {
        Partita p = partitaRepository.findById(partitaId).orElse(null);
        return p != null ? p.getCommenti() : null;
    }

    
    @PostMapping("/{partitaId}")
    public Commento aggiungiCommento(@PathVariable Long partitaId, @RequestBody Commento nuovoCommento) {
        Partita p = partitaRepository.findById(partitaId).get();
        nuovoCommento.setPartita(p);
        return commentoRepository.save(nuovoCommento);
    }
}