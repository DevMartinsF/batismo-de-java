package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Boas Vindas";
    }

    @PostMapping("/adicionarNinjas")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO novoNinja) {
        NinjaDTO ninjaDTO = ninjaService.adicionarNinja(novoNinja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Ninja " + novoNinja.getNome() + " foi criado");
    }

    @GetMapping("/mostrarNinjas")
    public ResponseEntity<List<NinjaDTO>> mostarNinjas() {
        List<NinjaDTO>listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    @GetMapping("/mostarNinjaID/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorId(id);
        if ( ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(ninjaDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    @PutMapping ("/atualizarNinja/{id}")
    public ResponseEntity<?> atualizarNinja (@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("O ninja não pode ser atualizado, revise as informações e tente novamente");
        }
    }

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
