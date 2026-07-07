package it.uniroma3.siw_tornei_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw_tornei_01.model.Arbitro;
import it.uniroma3.siw_tornei_01.repository.ArbitroRepository;

@Service
public class ArbitroService {

    @Autowired
    private ArbitroRepository arbitroRepository;

    public List<Arbitro> findAll() {
        return (List<Arbitro>) arbitroRepository.findAll();
    }

    public Arbitro findById(Long id) {
        return arbitroRepository.findById(id).orElse(null);
    }

    public Arbitro save(Arbitro arbitro) {
        return arbitroRepository.save(arbitro);
    }


    public void deleteById(Long id) {
        arbitroRepository.deleteById(id);
    }
}