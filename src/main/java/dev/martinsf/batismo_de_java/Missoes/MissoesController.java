package dev.martinsf.batismo_de_java.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/missoes")
public class MissoesController {
    private final MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @Operation (summary = "Adiciona uma nova missao", description = "Recebe os dados de uma missao, realiza a persistência no banco de dados e retorna uma mensagem confirmando o sucesso da operação")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Retorna uma mensagem informando que a missao foi criada"),
            @ApiResponse (responseCode = "400", description = "Retorna uma mensagem informando falha na criação da missao ")
    })
    @PostMapping ("/adicionarMissao")
    public ResponseEntity <String> adicionarMissao(@RequestBody MissoesDTO novaMissao){
        MissoesDTO missoesDTO = missoesService.adicionarMissao(novaMissao);
        if (missoesDTO != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Missao adicionada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A missao não pode ser adicionada, revise e tente novamente");
        }
    }
    @Operation (summary = "Mostra as missões cadastradas", description = "Retorna uma lista com todas as missoões contidas no Banco de Dados")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "404", description = "Retorna uma mensagem informando que nenhuma missao foi encontrada"),
            @ApiResponse (responseCode = "200", description = "Retorna a lista com as missões")
    })
    @GetMapping ("/mostrarMissoes")
    public ResponseEntity <?> mostrarTodasAsMissoes() {
        List <MissoesDTO> missoesDTO = missoesService.mostrarMissoes();
        if (missoesDTO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma missao encontrada");
        } else {
            return ResponseEntity.ok(missoesDTO);
        }
    }
    @Operation (summary = "Mostra a missao pelo id", description = "Retorna a missão do ID inserido e seus dados")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Retorna a missão do ID"),
            @ApiResponse (responseCode = "404", description = "Retorna uma mensagem informando que a missão não foi encontrada")
    })
    @GetMapping ("/mostarMissaoID/{id}")
    public ResponseEntity <?> mostrarMissaoId(@PathVariable Long id) {
        MissoesDTO missoesDTO = missoesService.mostrarMissaoPorId(id);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        } else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID: " + id + " não foi encontrada");
        }
    }
    @Operation (summary = "Atualiza a missão", description = "Atualiza uma missão já existente")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Retorna uma mensagem informando que a missão foi atualizada"),
            @ApiResponse (responseCode = "400", description = "Retorna uma mensagem informando um erro ao tentar atualizar a missao do ID inserido")
    })
    @PutMapping ("/atualizarMissao")
    public ResponseEntity <String> atualizarMissao (Long id, MissoesDTO missoesDTOAtualizada){
        MissoesDTO missoesDTO = missoesService.atualizarMissao(id, missoesDTOAtualizada);
        if (missoesDTO != null){
        return ResponseEntity.ok("Missão de ID: " + id + " foi atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel atualizar a missao de ID: " + id);
        }
    }
    @Operation (summary = "Deleta missao", description = "Deleta a missão com ID correspondente")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Retorna uma mensagem informando que a missao de ID correspondente foi deletada"),
            @ApiResponse (responseCode = "404", description = "Retorna uma mensagem informando que não foi possivel deletar a missao")
    })
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
