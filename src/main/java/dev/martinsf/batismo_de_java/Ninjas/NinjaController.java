package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("ninjas")
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas (){
        return "Boas Vindas";
    }

    @PostMapping ("/adicionarNinjas")
    public String criarNinja(){
        return "Criado";
    }

    @GetMapping ("/mostrarNinjas")
    public String mostarNinjas (){
        return "Ninjas";
    }

    @GetMapping ("/mostarNinjaID")
    public String mostrarNinjaPorId (){
        return "Ninja ID";
    }
    @PutMapping ("/atualizarNinja")
    public String atualizarNinja (){
        return "Ninja Atualizado";
    }

    @DeleteMapping ("/deletarNinja")
    public String deletarNinja(){
        return "Ninja deletado";
    }
}
