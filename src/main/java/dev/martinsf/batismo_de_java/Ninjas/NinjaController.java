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
    public NinjaModel adicionarNinja(@RequestBody NinjaModel novoNinja){
        return ninjaService.adicionarNinja(novoNinja);
    }

    @GetMapping ("/mostrarNinjas")
    public List <NinjaModel> mostarNinjas (){
        return ninjaService.listarNinjas();
    }

    @GetMapping ("/mostarNinjaID/{id}")
    public NinjaModel mostrarNinjaPorId (@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }
    @PutMapping ("/atualizarNinja")
    public String atualizarNinja (){
        return "Ninja Atualizado";
    }

    @DeleteMapping ("/deletarNinja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id); ;
    }
}
