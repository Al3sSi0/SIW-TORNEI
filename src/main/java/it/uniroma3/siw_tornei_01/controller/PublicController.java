package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw_tornei_01.repository.SquadraRepository;
import it.uniroma3.siw_tornei_01.service.PartitaService;
import it.uniroma3.siw_tornei_01.service.SquadraService;
import it.uniroma3.siw_tornei_01.service.TorneoService;

@Controller
public class PublicController {

    @Autowired private TorneoService torneoService;
    @Autowired private PartitaService partitaService;
    @Autowired private SquadraRepository squadraRepository;
    @Autowired private SquadraService squadraService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tornei")
    public String getTornei(Model model) {
        model.addAttribute("tornei", torneoService.findAll());
        return "tornei";
    }

    @GetMapping("/partite")
    public String getPartite(Model model) {
        model.addAttribute("partite", partitaService.findAll()); 
        return "partite";
    }

    @GetMapping("/squadre")
    public String getSquadre(Model model) {
        model.addAttribute("squadre", this.squadraRepository.findAll());
        return "squadre";
    }

    @GetMapping("/squadra/{id}")
        public String getSquadra(@PathVariable("id") Long id, Model model) {
            model.addAttribute("squadra", this.squadraService.findById(id)); 
            return "squadra"; 
        }
}