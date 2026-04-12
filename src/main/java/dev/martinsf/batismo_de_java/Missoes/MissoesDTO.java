package dev.martinsf.batismo_de_java.Missoes;

import dev.martinsf.batismo_de_java.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {
    private Long id;
    private String nome;
    private String rank;
    private List<NinjaModel> ninjasDaMissao;

}
