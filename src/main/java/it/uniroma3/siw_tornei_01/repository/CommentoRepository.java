package it.uniroma3.siw_tornei_01.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Commento;

public interface CommentoRepository extends CrudRepository<Commento, Long> {
}