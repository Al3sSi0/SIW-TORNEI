package it.uniroma3.siw_tornei_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw_tornei_01.model.Squadra;
import it.uniroma3.siw_tornei_01.repository.SquadraRepository;

@Service
public class SquadraService {

    @Autowired
    private SquadraRepository squadraRepository;

    @Transactional
    public void save(Squadra squadra) {
        squadraRepository.save(squadra);
    }
    
    public Iterable<Squadra> findAll() {
        return squadraRepository.findAll();
    }

    public Squadra findById(Long id) {
        return squadraRepository.findById(id).orElse(null);
    }
}