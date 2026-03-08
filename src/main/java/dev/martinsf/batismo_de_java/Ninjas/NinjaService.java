package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List <NinjaModel> listarNinjas (){
        return ninjaRepository.findAll();
    }
}
