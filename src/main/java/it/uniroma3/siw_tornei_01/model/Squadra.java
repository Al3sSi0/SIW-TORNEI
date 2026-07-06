package it.uniroma3.siw_tornei_01.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Squadra {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private Integer annoDiFondazione;
    private String citta;

    
    @ManyToMany
    private List<Torneo> tornei;

    
    @OneToMany(mappedBy = "squadra")
    private List<Giocatore> giocatori;

    public Squadra(String nome, Integer annoDiFondazione, String citta) {
        this.nome = nome;
        this.annoDiFondazione = annoDiFondazione;
        this.citta = citta;
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

    public Integer getAnnoDiFondazione() {
        return annoDiFondazione;
    }

    public void setAnnoDiFondazione(Integer annoDiFondazione) {
        this.annoDiFondazione = annoDiFondazione;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Torneo> getTornei() {
        return tornei;
    }

    public void setTornei(List<Torneo> tornei) {
        this.tornei = tornei;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

}