package dev.martinsf.batismo_de_java.Ninjas;

import dev.martinsf.batismo_de_java.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private  String nome;
    private  int idade;
    @Column(unique = true)
    private  String gmail;

    @ManyToOne
    @JoinColumn (name = "missao_id")
    private MissoesModel missao;

    private String rank;
}
