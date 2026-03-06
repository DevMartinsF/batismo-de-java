package dev.martinsf.batismo_de_java.Missoes;

import dev.martinsf.batismo_de_java.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;
    @OneToMany (mappedBy = "missao")
    private List<NinjaModel> ninjasDaMissao;
}
