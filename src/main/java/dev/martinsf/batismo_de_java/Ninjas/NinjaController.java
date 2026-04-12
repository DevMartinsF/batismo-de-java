package dev.martinsf.batismo_de_java.Ninjas;

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
    public String boasVindas (){
        return "Boas Vindas";
    }

    @PostMapping ("/adicionarNinjas")
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO novoNinja){
        return ninjaService.adicionarNinja(novoNinja);
    }

    @GetMapping ("/mostrarNinjas")
    public List <NinjaDTO> mostarNinjas (){
        return ninjaService.listarNinjas();
    }

    @GetMapping ("/mostarNinjaID/{id}")
    public NinjaDTO mostrarNinjaPorId (@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    @PutMapping ("/atualizarNinja/{id}")
    public NinjaDTO atualizarNinja (@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }

    @DeleteMapping ("/deletarNinja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
