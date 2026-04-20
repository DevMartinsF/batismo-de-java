package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List <MissoesDTO> mostrarMissoes(){
        List <MissoesModel> ninjaModelList = missoesRepository.findAll();
        return ninjaModelList.stream()
                .map(missoesMapper::mapperDTO)
                .collect(Collectors.toList());
    }

    public MissoesDTO mostrarMissaoPorId(Long id){
        Optional <MissoesModel> ninjaId = missoesRepository.findById(id);
        return ninjaId.map(missoesMapper::mapperDTO).orElse(null);
    }

    public MissoesDTO adicionarMissao(MissoesDTO novaMissaoDTO){
        MissoesModel missoesModel = missoesMapper.mapperModel(novaMissaoDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.mapperDTO(missoesModel);
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesDTO atualizarMissao(long id, MissoesDTO missoesDTOAtualizada) {
        Optional<MissoesModel> missoesModelOptional = missoesRepository.findById(id);
        if (missoesModelOptional.isPresent()) {
            MissoesModel novaMissao = missoesMapper.mapperModel(missoesDTOAtualizada);
            novaMissao.setId(id);
            MissoesModel missaoAlterada = missoesRepository.save(novaMissao);
            return missoesMapper.mapperDTO(missaoAlterada);
        }
        return null;
    }
}
