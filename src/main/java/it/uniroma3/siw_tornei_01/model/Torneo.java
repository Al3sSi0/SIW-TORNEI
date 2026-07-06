package it.uniroma3.siw_tornei_01.model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;


@Entity
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Il nome del torneo è obbligatorio")
    private String nome;
    @Min(value = 1900, message = "L'anno non può essere precedente al 1900")
    private int anno;
    private String descrizione;
    private String imgUrl;

    @ManyToMany(mappedBy = "tornei")
    private List<Squadra> squadre;
    
    public Torneo(String nome, int anno, String descrizione) {
    this.nome = nome;
    this.anno = anno;
    this.descrizione = descrizione;
}
    public String getNome() {
        return nome;
    }
    public Integer getAnno() {
        return anno;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAnno(Integer anno) {
        this.anno = anno;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
