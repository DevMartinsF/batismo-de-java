package dev.martinsf.batismo_de_java.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper{

    public NinjaModel mapper(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setGmail(ninjaDTO.getGmail());
        ninjaModel.setMissao(ninjaDTO.getMissao());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }
     public NinjaDTO mapperDTO(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
         ninjaDTO.setId(ninjaModel.getId());
         ninjaDTO.setNome(ninjaModel.getNome());
         ninjaDTO.setIdade(ninjaModel.getIdade());
         ninjaDTO.setGmail(ninjaModel.getGmail());
         ninjaDTO.setMissao(ninjaModel.getMissao());
         ninjaDTO.setRank(ninjaModel.getRank());

         return ninjaDTO;
     }
}
