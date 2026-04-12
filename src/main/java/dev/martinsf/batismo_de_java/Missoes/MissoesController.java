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
    public MissoesDTO adicionarMissao(@RequestBody MissoesDTO novaMissao){
        return missoesService.adicionarMissao(novaMissao);
    }

    @GetMapping ("/mostrarMissoes")
    public List <MissoesDTO> mostrarTodasAsMissoes() {
    return missoesService.mostrarMissoes();
    }

    @GetMapping ("/mostarMissaoID/{id}")
    public MissoesDTO mostrarMissaoId(@PathVariable Long id) {
        return missoesService.mostrarMissaoPorId(id);
    }

    @PutMapping ("/atualizarMissao")
    public MissoesDTO atualizarMissao (Long id, MissoesDTO missoesDTOAtualizada){
        return missoesService.atualizarMissao(id, missoesDTOAtualizada);
    }

    @DeleteMapping ("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
