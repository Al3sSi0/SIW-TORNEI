package it.uniroma3.siw_tornei_01.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
}