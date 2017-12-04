package br.unipe.series.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EpisodioVisto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Episodio episodio;

    @Temporal(TemporalType.DATE)
    private Date data;

    public EpisodioVisto(Episodio episodio) {
        this.episodio = episodio;
        this.data = new Date();
    }
}
