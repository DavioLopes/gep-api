package br.com.attornatus.gepApi.mapper;


import br.com.attornatus.gepApi.dto.PessoaDTO;
import br.com.attornatus.gepApi.entity.PessoaEntity;

public class PessoaMapper {


    public static PessoaDTO entityToDto(PessoaEntity entity) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(entity.getId());
        pessoaDTO.setNome(entity.getNome());
        pessoaDTO.setDataDeNascimento(entity.getDataDeNascimento());

        return pessoaDTO;
    }

    public static PessoaEntity dtoToEntity(PessoaDTO dto) {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setId(dto.getId());
        pessoaEntity.setNome(dto.getNome());
        pessoaEntity.setDataDeNascimento(dto.getDataDeNascimento());

        return pessoaEntity;
    }

}
