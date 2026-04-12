package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas() {
        List <NinjaModel> ninjaModelList =  ninjaRepository.findAll();
        return ninjaModelList.stream()
                .map(ninjaMapper::mapperDTO)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::mapperDTO).orElse(null);
    }

    public NinjaDTO adicionarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.mapperModel(ninjaDTO);
       ninjaModel = ninjaRepository.save(ninjaModel);
       return ninjaMapper.mapperDTO(ninjaModel);
    }

    public void deletarNinja (long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja (Long id, NinjaDTO ninjaDTO){
     Optional <NinjaModel> ninja = ninjaRepository.findById(id);
     if (ninja.isPresent()){
         NinjaModel ninjaAtualizado = ninjaMapper.mapperModel(ninjaDTO);
         ninjaAtualizado.setId(id);
         NinjaModel ninjaAlterado = ninjaRepository.save(ninjaAtualizado);
         return ninjaMapper.mapperDTO(ninjaAlterado);
     }
     return null;
    }
}

