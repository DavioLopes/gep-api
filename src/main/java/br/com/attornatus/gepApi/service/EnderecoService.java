package br.com.attornatus.gepApi.service;

import br.com.attornatus.gepApi.dto.EnderecoDTO;
import br.com.attornatus.gepApi.dto.PessoaDTO;
import br.com.attornatus.gepApi.entity.EnderecoEntity;
import br.com.attornatus.gepApi.entity.PessoaEntity;
import br.com.attornatus.gepApi.error.NotFoundException;
import br.com.attornatus.gepApi.mapper.EnderecoMapper;
import br.com.attornatus.gepApi.mapper.PessoaMapper;
import br.com.attornatus.gepApi.repository.EnderecoRepository;
import br.com.attornatus.gepApi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    public EnderecoRepository enderecoRepository;

    @Autowired
    public PessoaRepository pessoaRepository;

    public EnderecoDTO salvarEndereco(EnderecoDTO dto){
        Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(dto.getIdPessoa());
        EnderecoEntity enderecoEntity = EnderecoMapper.dtoToEntity(dto);
        enderecoEntity.setPessoa(pessoaEntity.get());
        enderecoRepository.save(enderecoEntity);
        dto.setId(enderecoEntity.getId());
        return  dto;

    }

    public List<EnderecoDTO> listarEnderecos(Integer id) {
        try {
            Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(id);
            PessoaDTO pessoaDTO = PessoaMapper.entityToDto(pessoaEntity.get());
            pessoaDTO.setEnderecos(new ArrayList<>());
            for (EnderecoEntity enderecoEntity : pessoaEntity.get().getEnderecos()) {
                EnderecoDTO enderecoDTO = EnderecoMapper.entityToDto(enderecoEntity);
                enderecoDTO.setIdPessoa(pessoaDTO.getId());
                pessoaDTO.getEnderecos().add(enderecoDTO);
            }
            return pessoaDTO.getEnderecos();
        } catch (Exception e) {
            throw new NotFoundException("pessoa nao encontrada");
        }
    }
    public EnderecoDTO editarEnderecos(EnderecoDTO dto) {
        try {
            Optional<EnderecoEntity> enderecoEntity = enderecoRepository.findById(dto.getId());
            enderecoEntity.get().setCep(dto.getCep());
            enderecoEntity.get().setLogadouro(dto.getLogadouro());
            enderecoEntity.get().setNumero(dto.getNumero());
            enderecoEntity.get().setCidade(dto.getCidade());
            enderecoEntity.get().setPrincipal(dto.getPrincipal());

            enderecoRepository.save(enderecoEntity.get());
            return dto;
        } catch (Exception e) {
            throw new NotFoundException("Endereço não encontrado");
        }
    }


}