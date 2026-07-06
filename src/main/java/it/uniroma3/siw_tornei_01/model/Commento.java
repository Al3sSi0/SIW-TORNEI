package it.uniroma3.siw_tornei_01.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Commento {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 500)
    private String testo;
    private LocalDateTime dataEOra;

    @ManyToOne(fetch = FetchType.LAZY)
    private Utente autore;

    @ManyToOne(fetch = FetchType.LAZY)
    private Partita partita;

    

    public Commento(String testo, LocalDateTime dataEOra, Utente autore) {
        this.testo = testo;
        this.dataEOra = dataEOra;
        this.autore = autore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public LocalDateTime getDataEOra() {
        return dataEOra;
    }

    public void setDataEOra(LocalDateTime dataEOra) {
        this.dataEOra = dataEOra;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    public Partita getPartita() {
        return partita;
    }

    public void setPartita(Partita partita) {
        this.partita = partita;
    }

    
}