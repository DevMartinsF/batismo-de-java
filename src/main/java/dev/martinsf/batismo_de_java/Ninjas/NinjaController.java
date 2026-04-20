package dev.martinsf.batismo_de_java.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @Operation (summary = "Cadastrar um novo ninja", description = "Recebe os dados de um ninja, realiza a persistência no banco de dados e retorna uma mensagem confirmando o sucesso da operação")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Ninja criado"),
            @ApiResponse (responseCode = "400", description = "Falha ao criar o ninja")
    } )
    @PostMapping("/adicionarNinjas")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO novoNinja) {
        NinjaDTO ninjaDTO = ninjaService.adicionarNinja(novoNinja);
        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Ninja " + novoNinja.getNome() + " foi criado");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel criar o novo ninja");
        }
    }
    @Operation (summary = "Mostra todos os ninjas cadastrados", description = "Busca todos os ninjas retornando uma lista com todos os ninjas cadastrados")
    @ApiResponses (value ={
            @ApiResponse (responseCode = "404", description = "Nenhum ninja encontrado"),
            @ApiResponse (responseCode = "200", description = "Retorna a lista com os ninjas cadastrados")
    })
    @GetMapping("/mostrarNinjas")
    public ResponseEntity<?> mostarNinjas() {
        List<NinjaDTO>listaDeNinjas = ninjaService.listarNinjas();
       if (listaDeNinjas.isEmpty()){
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum ninja cadastrado");
           }else {
           return ResponseEntity.ok(listaDeNinjas);
       }
    }
    @Operation (summary = "Busca um ninja por ID", description = "Busca no banco dados o ninja pelo ID inserido")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "302", description = "Retorna o ninja encontrado"),
            @ApiResponse (responseCode = "404", description = "Retorna uma mensagem informando que o ninja não foi encontrado")
    })
    @GetMapping("/mostarNinjaID/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if ( ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(ninjaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }
@Operation (summary = "Atualiza o ninja ", description = "Através do ID recebido busca e atualiza o ninja com os novos dados")
@ApiResponses (value={
        @ApiResponse (responseCode = "200", description = "Retorna informando que o ninja foi atualizado"),
        @ApiResponse (responseCode = "400", description = "Retorna uma mensagem monstrando que o ninja não pode ser atualizado")
})
    @PutMapping ("/atualizarNinja/{id}")
    public ResponseEntity<?> atualizarNinja (@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ninja não pode ser atualizado, revise as informações e tente novamente");
        }
    }
    @Operation(summary = "Deleta o ninja por ID", description = "Busca no banco de dados o ninja com o ID inserido e o deleta")
    @ApiResponses (value = {
        @ApiResponse (responseCode = "200", description = "Retorna uma mensagem avisando que o ninja foi deletado"),
            @ApiResponse(responseCode = "404", description = "Retorna uma mensagem informando que o ninja não pôde ser deletado")
    })
    @DeleteMapping ("/deletarNinja/{id}")
    public ResponseEntity <String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("O ninja de ID: " + id + " foi deletado ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja de ID: " + id + "não foi encontrado");
        }
    }
}
