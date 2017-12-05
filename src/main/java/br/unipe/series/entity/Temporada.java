package br.unipe.series.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Temporada {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numero;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="episodio_id", referencedColumnName = "id")
    private List<Episodio> episodios;

    @ManyToOne
    private Serie serie;

    public Temporada() {
    }

    public Temporada(Long id, Long numero) {
        this.id = id;
        this.numero = numero;
    }

    public void addEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }
}
