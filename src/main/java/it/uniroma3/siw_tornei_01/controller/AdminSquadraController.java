package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_tornei_01.model.Squadra;
import it.uniroma3.siw_tornei_01.service.SquadraService;

@Controller
public class AdminSquadraController {

    @Autowired
    private SquadraService squadraService;

    @GetMapping("/admin/squadra/nuova")
    public String formNuovaSquadra(Model model) {
        model.addAttribute("squadra", new Squadra(null, 0, null));
        return "admin/squadraForm";
    }

    @PostMapping("/admin/squadra")
    public String salvaSquadra(@ModelAttribute("squadra") Squadra squadra) {
        this.squadraService.save(squadra);
        return "redirect:/";
    }

    @GetMapping("/admin/squadra/modifica/{id}")
    public String formModificaSquadra(@PathVariable("id") Long id, Model model) {
        Squadra squadraEsistente = this.squadraService.findById(id);
        
        if (squadraEsistente == null) {
            return "redirect:/squadre";
        }
        
        model.addAttribute("squadra", squadraEsistente);
        
        return "admin/squadraForm";
    }
}