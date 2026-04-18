package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <String> adicionarMissao(@RequestBody MissoesDTO novaMissao){
        MissoesDTO missoesDTO = missoesService.adicionarMissao(novaMissao);
        if (missoesDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Missao adicionada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A missao não pode ser adicionada, revise e tente novamente");
        }
    }

    @GetMapping ("/mostrarMissoes")
    public ResponseEntity <?> mostrarTodasAsMissoes() {
        List <MissoesDTO> missoesDTO = missoesService.mostrarMissoes();
        if (missoesDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma missao encontrada");
        } else {
            return ResponseEntity.ok(missoesDTO);
        }
    }

    @GetMapping ("/mostarMissaoID/{id}")
    public ResponseEntity <?> mostrarMissaoId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.mostrarMissaoPorId(id);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID: " + id + " não foi encontrada");
        }
    }

    @PutMapping ("/atualizarMissao")
    public ResponseEntity <String> atualizarMissao (Long id, MissoesDTO missoesDTOAtualizada){
        MissoesDTO missoesDTO = missoesService.atualizarMissao(id, missoesDTOAtualizada);
        if (missoesDTO != null){
        return ResponseEntity.ok("Missão de ID: " + id + " foi atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel atualizar a missao de ID: " + id);
        }
    }

    @DeleteMapping ("/deletarMissao/{id}")
    public ResponseEntity <String> deletarMissao(@PathVariable Long id){
        if (missoesService.mostrarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missao deletada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel deletar a missao");
        }
    }
}
