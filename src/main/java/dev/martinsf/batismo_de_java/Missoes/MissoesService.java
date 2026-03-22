package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List <MissoesModel> mostrarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel mostrarMissaoPorId(Long id){
        Optional <MissoesModel> ninjaId = missoesRepository.findById(id);
        return ninjaId.orElse(null);
    }

    public MissoesModel adicionarMissao(MissoesModel novaMissao){
        return missoesRepository.save(novaMissao);
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
}
