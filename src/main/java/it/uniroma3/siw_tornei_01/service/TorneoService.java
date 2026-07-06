package it.uniroma3.siw_tornei_01.service;

import it.uniroma3.siw_tornei_01.model.Torneo;
import it.uniroma3.siw_tornei_01.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    @Transactional
    public Torneo getTorneo(Long id) {
        return torneoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Iterable<Torneo> findAll() {
        return torneoRepository.findAll();
    }

    @Transactional
    public void save(Torneo torneo) {
        torneoRepository.save(torneo);
    }
}