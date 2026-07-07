package it.uniroma3.siw_tornei_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw_tornei_01.model.Giocatore;
import it.uniroma3.siw_tornei_01.repository.GiocatoreRepository;
import it.uniroma3.siw_tornei_01.service.SquadraService;

@Controller
@RequestMapping("/admin/giocatore")
public class AdminGiocatoreController {

    @Autowired private GiocatoreRepository giocatoreRepo;
    @Autowired private SquadraService squadraService;

    @GetMapping("/nuovo")
    public String formGiocatore(Model model) {
        model.addAttribute("giocatore", new Giocatore(null, null, null, null, null));
        model.addAttribute("squadre", squadraService.findAll());
        return "admin/giocatoreForm";
    }

    @PostMapping("")
    public String salvaGiocatore(@ModelAttribute Giocatore g) {
        giocatoreRepo.save(g);
        return "redirect:/"; 
    }

    @GetMapping("/elimina/{id}")
    public String eliminaGiocatore(@PathVariable Long id) {
        giocatoreRepo.deleteById(id);
        return "redirect:/admin";
    }
}