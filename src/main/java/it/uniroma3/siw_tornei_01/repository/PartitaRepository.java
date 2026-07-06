package it.uniroma3.siw_tornei_01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw_tornei_01.model.Partita;

public interface PartitaRepository extends CrudRepository<Partita, Long> {
    
    // Metodo base: causerà il problema N+1 a causa del caricamento LAZY
    Optional<Partita> findById(Long id);

    // Metodo OTTIMIZZATO: Risolve il problema N+1 con una singola JOIN
    @EntityGraph(attributePaths = {"squadraHome", "squadraAway", "torneo"})
    Optional<Partita> findPartitaWithDetailsById(Long id);
}