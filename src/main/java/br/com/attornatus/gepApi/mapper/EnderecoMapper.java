package br.com.attornatus.gepApi.mapper;


import br.com.attornatus.gepApi.dto.EnderecoDTO;
import br.com.attornatus.gepApi.entity.EnderecoEntity;

public class EnderecoMapper {

    public static EnderecoDTO entityToDto(EnderecoEntity entity) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(entity.getId());
        enderecoDTO.setLogadouro(entity.getLogadouro());
        enderecoDTO.setCidade(entity.getCidade());
        enderecoDTO.setNumero(entity.getNumero());
        enderecoDTO.setCep(entity.getCep());
        enderecoDTO.setPrincipal(entity.getPrincipal());
        return enderecoDTO;
    }

    public static EnderecoEntity dtoToEntity(EnderecoDTO dto) {
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setId(dto.getId());
        enderecoEntity.setLogadouro(dto.getLogadouro());
        enderecoEntity.setCidade(dto.getCidade());
        enderecoEntity.setNumero(dto.getNumero());
        enderecoEntity.setCep(dto.getCep());
        enderecoEntity.setPrincipal(dto.getPrincipal());
        return enderecoEntity;
    }

}
