package dev.martinsf.batismo_de_java.Ninjas;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private Long id;
    private  String nome;
    private  int idade;
    private  String gmail;

    public NinjaModel(Long id, String nome, int idade, String gmail) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.gmail = gmail;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
