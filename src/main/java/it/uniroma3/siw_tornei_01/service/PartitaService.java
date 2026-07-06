package it.uniroma3.siw_tornei_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_tornei_01.model.Partita;
import it.uniroma3.siw_tornei_01.repository.PartitaRepository;

@Service
public class PartitaService {

    @Autowired
    private PartitaRepository partitaRepository;

    // Metodo LENTO per la tua relazione (mostrerà tante query)
    @Transactional
    public Partita getPartita(Long id) {
        return partitaRepository.findById(id).orElse(null);
    }

    // Metodo VELOCE per la tua relazione (mostrerà una sola query)
    @Transactional
    public Partita getPartitaConDettagli(Long id) {
        return partitaRepository.findPartitaWithDetailsById(id).orElse(null);
    }

    @Transactional
    public void aggiornaRisultato(Long id, Integer golCasa, Integer golTrasferta) {
        Partita p = partitaRepository.findById(id).orElseThrow();
        p.setGoalsHome(golCasa);
        p.setGoalsAway(golTrasferta);
        p.setStato("PLAYED"); // Assicurati di aver generato il setter setStato() nell'entità Partita
        partitaRepository.save(p);
    }

    public Iterable<Partita> findAll() {
        return partitaRepository.findAll();
    }
}
