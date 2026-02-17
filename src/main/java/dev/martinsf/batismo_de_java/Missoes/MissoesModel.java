package dev.martinsf.batismo_de_java.Missoes;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankDeMissoes rank;

    public MissoesModel(Long id, String nome, RankDeMissoes rank) {
        this.id = id;
        this.nome = nome;
        this.rank = rank;
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

    public RankDeMissoes getRank() {
        return rank;
    }

    public void setRank(RankDeMissoes rank) {
        this.rank = rank;
    }
}
