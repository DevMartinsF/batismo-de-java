package dev.martinsf.batismo_de_java.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

        public MissoesModel mapperModel(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setRank(missoesDTO.getRank());
        missoesModel.setNinjasDaMissao(missoesDTO.getNinjasDaMissao());

        return missoesModel;
        }
        public MissoesDTO mapperDTO(MissoesModel missoesModel){
            MissoesDTO missoesDTO = new MissoesDTO();
            missoesDTO.setId(missoesModel.getId());
            missoesDTO.setNome(missoesModel.getNome());
            missoesDTO.setRank(missoesModel.getRank());
            missoesDTO.setNinjasDaMissao(missoesModel.getNinjasDaMissao());

            return missoesDTO;
        }
}
