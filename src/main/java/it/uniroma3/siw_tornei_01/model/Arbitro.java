package it.uniroma3.siw_tornei_01.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Arbitro {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String cognome;
    private String matricola;

    @OneToMany(mappedBy = "arbitro")
    private List<Partita> partiteArbitrate;

    public Arbitro(){
        
    }
    
    public Arbitro(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public List<Partita> getPartiteArbitrate() {
        return partiteArbitrate;
    }

    public void setPartiteArbitrate(List<Partita> partiteArbitrate) {
        this.partiteArbitrate = partiteArbitrate;
    }
}
