package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw_tornei_01.model.Partita;
import it.uniroma3.siw_tornei_01.service.ArbitroService;
import it.uniroma3.siw_tornei_01.service.PartitaService;
import it.uniroma3.siw_tornei_01.service.SquadraService;
import it.uniroma3.siw_tornei_01.service.TorneoService;

@Controller
@RequestMapping("/admin") 
public class AdminPartitaController {

    @Autowired private PartitaService partitaService;
    @Autowired private SquadraService squadraService;
    @Autowired private TorneoService torneoService;
    @Autowired private ArbitroService arbitroService;

    @GetMapping("/partita/risultato/{id}")
    public String formRisultato(@PathVariable("id") Long id, Model model) {
        model.addAttribute("partita", this.partitaService.getPartitaConDettagli(id));
        return "admin/risultatoForm";
    }

    @PostMapping("/partita/risultato/{id}")
    public String salvaRisultato(@PathVariable("id") Long id, 
                                 @RequestParam Integer golHome, 
                                 @RequestParam Integer golAway) {
        this.partitaService.aggiornaRisultato(id, golHome, golAway);
        return "redirect:/tornei";
    }

    @GetMapping("/partita/nuova")
    public String formNuovaPartita(Model model) {
        model.addAttribute("partita", new Partita());
        model.addAttribute("squadre", squadraService.findAll());
        model.addAttribute("tornei", torneoService.findAll());
        model.addAttribute("arbitri", arbitroService.findAll());
        return "admin/partitaForm";
    }

    @PostMapping("/partita")
    public String salvaPartita(@ModelAttribute("partita") Partita partita) {
        partitaService.save(partita);
        return "redirect:/partite";
    }

}