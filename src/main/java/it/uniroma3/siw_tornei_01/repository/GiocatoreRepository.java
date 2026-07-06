package it.uniroma3.siw_tornei_01.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Giocatore;

public interface GiocatoreRepository extends CrudRepository<Giocatore, Long> {
    // Ereditiamo tutti i metodi CRUD da CrudRepository
}
