package br.unipe.series.entity;

import javax.persistence.*;

@Entity
public class Episodio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private String description;

    public Episodio(String nome, String descricao, String imagem, String description) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.description = description;
    }
}
