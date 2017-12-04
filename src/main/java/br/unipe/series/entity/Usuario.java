package br.unipe.series.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String facebookId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String foto;

    @Column(nullable = true)
    private String accessToken;

    @OneToMany
    private List<Serie> series;

    @OneToMany
    private List<EpisodioVisto> episodiosVistos;

    public Usuario() {
    }

    public Usuario(String facebookId, String nome, String foto, String accessToken) {
        this.facebookId = facebookId;
        this.nome = nome;
        this.foto = foto;
        this.accessToken = accessToken;
    }

    public void atualizarToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void addSerie(Serie serie) {
        series.add(serie);
    }

    public void addVisto(EpisodioVisto visto) {
        episodiosVistos.add(visto);
    }

    public Long getId() {
        return id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public String getNome() {
        return nome;
    }

    public String getFoto() {
        return foto;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public List<EpisodioVisto> getEpisodiosVistos() {
        return episodiosVistos;
    }
}
