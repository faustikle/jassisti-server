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

    @Column(nullable = false, length = 10485760)
    private String descricao;

    @Column(nullable = false)
    private String foto;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Temporada> temporadas;

    public Serie() {
    }

    public Serie(Long id, String nome, String descricao, String foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFoto() {
        return foto;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void addTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }
}
