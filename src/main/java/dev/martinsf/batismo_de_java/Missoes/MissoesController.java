package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping ("/adicionarMissao")
    public String adicionarMissao(){
        return "Missao adicionada";
    }
    @GetMapping ("/mostrarMissoes")
    public List <MissoesModel> mostrarTodasAsMissoes() {
    return missoesService.mostrarMissoes();
    }
    @GetMapping ("/mostarMissaoID")
    public String mostrarMissaoId() {
        return "Missoes ID";
    }
    @PutMapping ("/atualizarMissao")
    public String atualizarMissao (){
        return "Missao atualizada";
    }

    @DeleteMapping ("/deletarMissao")
    public String deletarMissao(){
        return "Missao Deletada";
    }
}
