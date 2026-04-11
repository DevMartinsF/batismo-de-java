package dev.martinsf.batismo_de_java.Ninjas;

import dev.martinsf.batismo_de_java.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private  String nome;
    private  int idade;
    private  String gmail;
    private MissoesModel missao;
    private String rank;
}
