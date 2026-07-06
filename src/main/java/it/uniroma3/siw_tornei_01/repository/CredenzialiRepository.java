package it.uniroma3.siw_tornei_01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Credenziali;

public interface CredenzialiRepository extends CrudRepository<Credenziali, Long> {
    Optional<Credenziali> findByUsername(String username);
}