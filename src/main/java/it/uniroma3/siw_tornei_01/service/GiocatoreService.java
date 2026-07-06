package it.uniroma3.siw_tornei_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw_tornei_01.model.Giocatore;
import it.uniroma3.siw_tornei_01.repository.GiocatoreRepository;

@Service
public class GiocatoreService {
    @Autowired private GiocatoreRepository repo;

    @Transactional
    public void save(Giocatore g) { repo.save(g); }
    
    public Iterable<Giocatore> findAll() { return repo.findAll(); }
}