package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw_tornei_01.model.Torneo;
import it.uniroma3.siw_tornei_01.service.TorneoService;

@Controller
public class AdminTorneoController {

    @Autowired
    private TorneoService torneoService;

    @GetMapping("/admin/torneo/nuovo")
    public String formNuovoTorneo(Model model) {
        model.addAttribute("torneo", new Torneo(null, 0, null));
        return "admin/torneoForm";
    }

    @PostMapping("/admin/torneo")
    public String salvaTorneo(@ModelAttribute("torneo") Torneo torneo) {
        this.torneoService.save(torneo);
        return "redirect:/";
    }
}