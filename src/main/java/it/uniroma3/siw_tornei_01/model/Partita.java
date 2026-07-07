package it.uniroma3.siw_tornei_01.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Partita {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private LocalDateTime dataEOra;
    private String luogo;
    private Integer goalsHome;
    private Integer goalsAway;
    private String stato;

    @ManyToOne(fetch = FetchType.LAZY)
    private Squadra squadraHome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Squadra squadraAway;

    @ManyToOne(fetch = FetchType.LAZY)
    private Torneo torneo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Arbitro arbitro;

    @OneToMany(mappedBy = "partita", cascade = CascadeType.ALL)
    private List<Commento> commenti;

    public Partita(){

    }
    
    public Partita(LocalDateTime dataEOra, String luogo, Integer goalsHome, Integer goalsAway, String stato) {
        this.dataEOra = dataEOra;
        this.luogo = luogo;
        this.goalsHome = goalsHome;
        this.goalsAway = goalsAway;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataEOra() {
        return dataEOra;
    }

    public void setDataEOra(LocalDateTime dataEOra) {
        this.dataEOra = dataEOra;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public Integer getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(Integer goalsHome) {
        this.goalsHome = goalsHome;
    }

    public Integer getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(Integer goalsAway) {
        this.goalsAway = goalsAway;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Squadra getSquadraHome() {
        return squadraHome;
    }

    public void setSquadraHome(Squadra squadraHome) {
        this.squadraHome = squadraHome;
    }

    public Squadra getSquadraAway() {
        return squadraAway;
    }

    public void setSquadraAway(Squadra squadraAway) {
        this.squadraAway = squadraAway;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public List<Commento> getCommenti() {
        return commenti;
    }

    public void setCommenti(List<Commento> commenti) {
        this.commenti = commenti;
    }

    // Costruttori, Getter e Setter...
}
