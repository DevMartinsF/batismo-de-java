package dev.martinsf.batismo_de_java.Missoes;

import dev.martinsf.batismo_de_java.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankDeMissoes rank;
    private List<NinjaModel> ninjasDaMissao;

    public MissoesModel(Long id, String nome, RankDeMissoes rank, List<NinjaModel> ninjasDaMissao) {
        this.ninjasDaMissao = ninjasDaMissao;
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

    public List<NinjaModel> getNinjasDaMissao() {
        return ninjasDaMissao;
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

    public void setNinjasDaMissao(List<NinjaModel> ninjasDaMissao) {
        this.ninjasDaMissao = ninjasDaMissao;
    }
}
