package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas (){
        return "Boas Vindas";
    }
}
