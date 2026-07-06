package it.uniroma3.siw_tornei_01.repository;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Torneo;

public interface TorneoRepository extends CrudRepository<Torneo, Long> {}
