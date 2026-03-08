package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas (){
        return "Boas Vindas";
    }

    @PostMapping (name ="/criar")
    public String criarNinja(){
        return "Criado";
    }

    @GetMapping ("/mostrarninjas")
    public String mostarNinjas (){
        return "Ninjas";
    }

    @GetMapping ("/mostarninjaid")
    public String mostrarNinjaPorId (){
        return "Ninja ID";
    }
    @PutMapping ("/atualizarninja")
    public String atualizarNinja (){
        return "Ninja Atualizado";
    }

    @DeleteMapping ("/deletarNinja")
    public String deletarNinja(){
        return "Ninja deletado";
    }
}
