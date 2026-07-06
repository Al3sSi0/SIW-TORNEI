package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw_tornei_01.service.TorneoService;
import it.uniroma3.siw_tornei_01.service.PartitaService;
import it.uniroma3.siw_tornei_01.repository.SquadraRepository;

@Controller
public class PublicController {

    @Autowired private TorneoService torneoService;
    @Autowired private PartitaService partitaService;
    @Autowired private SquadraRepository squadraRepository;

    // Homepage
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Lista Tornei (Thymeleaf)
    @GetMapping("/tornei")
    public String getTornei(Model model) {
        model.addAttribute("tornei", torneoService.findAll());
        return "tornei";
    }

    // Calendario Partite
    @GetMapping("/partite")
    public String getPartite(Model model) {
        // Qui usi il metodo ottimizzato che abbiamo fatto per l'N+1!
        model.addAttribute("partite", partitaService.findAll()); // Assicurati di avere un findAll() in PartitaService
        return "partite";
    }

    // Lista Squadre
    @GetMapping("/squadre")
    public String getSquadre(Model model) {
        model.addAttribute("squadre", squadraRepository.findAll());
        return "squadre";
    }
}