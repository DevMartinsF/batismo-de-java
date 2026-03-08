package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List <MissoesModel> mostrarMissoes(){
        return missoesRepository.findAll();
    }
}
