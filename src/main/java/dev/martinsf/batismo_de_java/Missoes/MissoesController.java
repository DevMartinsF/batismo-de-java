package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {

    @PostMapping (name = "/adicionarmissao")
    public String adicionarMissao(){
        return "Missao adicionada";
    }
    @GetMapping (name = "/mostrarmissoes")
    public String mostrarTodasAsMissoes() {
    return "Todas Missoes";
    }
    @GetMapping (name = "/mostarmissaoid")
    public String mostrarMissaoId() {
        return "Missoes ID";
    }
    @PutMapping ("/atualizarM")
    public String atualizarMissao (){
        return "Missao atualizada";
    }

    @DeleteMapping (name = "/deletarM")
    public String deletarMissao(){
        return "Missao Deletada";
    }
}
