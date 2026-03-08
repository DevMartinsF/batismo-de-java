package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("missoes")
public class MissoesController {

    @PostMapping (name = "/adicionarMissao")
    public String adicionarMissao(){
        return "Missao adicionada";
    }
    @GetMapping (name = "/mostrarMissoes")
    public String mostrarTodasAsMissoes() {
    return "Todas Missoes";
    }
    @GetMapping (name = "/mostarMissaoID")
    public String mostrarMissaoId() {
        return "Missoes ID";
    }
    @PutMapping ("/atualizarMissao")
    public String atualizarMissao (){
        return "Missao atualizada";
    }

    @DeleteMapping (name = "/deletarMissao")
    public String deletarMissao(){
        return "Missao Deletada";
    }
}
