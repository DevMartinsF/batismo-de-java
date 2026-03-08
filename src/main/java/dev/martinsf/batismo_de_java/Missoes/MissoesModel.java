package dev.martinsf.batismo_de_java.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.martinsf.batismo_de_java.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;
    @OneToMany (mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjasDaMissao;
}
