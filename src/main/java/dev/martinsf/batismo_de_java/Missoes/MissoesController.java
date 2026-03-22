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
    public MissoesModel adicionarMissao(@RequestBody MissoesModel novaMissao){
        return missoesService.adicionarMissao(novaMissao);
    }

    @GetMapping ("/mostrarMissoes")
    public List <MissoesModel> mostrarTodasAsMissoes() {
    return missoesService.mostrarMissoes();
    }

    @GetMapping ("/mostarMissaoID/{id}")
    public MissoesModel mostrarMissaoId(@PathVariable Long id) {
        return missoesService.mostrarMissaoPorId(id);
    }

    @PutMapping ("/atualizarMissao")
    public String atualizarMissao (){
        return "Missao atualizada";
    }

    @DeleteMapping ("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
