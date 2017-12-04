package br.unipe.series.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String foto;

    @OneToMany
    private List<Episodio> episodios;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void addEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }
}
