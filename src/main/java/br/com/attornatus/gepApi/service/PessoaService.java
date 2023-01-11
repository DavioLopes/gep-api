package br.com.attornatus.gepApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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


@Service
public class PessoaService {
    @Autowired
    public PessoaRepository pessoaRepository;

    @Autowired
    public EnderecoRepository enderecoRepository;

    public PessoaDTO salvarPessoa(PessoaDTO dto) {
        PessoaEntity entity = PessoaMapper.dtoToEntity(dto);

        entity.setEnderecos(new ArrayList<>());

        pessoaRepository.save(entity);

        dto.setId(entity.getId());

        for (EnderecoDTO enderecoDTO : dto.getEnderecos()) {
            EnderecoEntity enderecoEntity = EnderecoMapper.dtoToEntity(enderecoDTO);
            enderecoEntity.setPessoa(entity);
            enderecoRepository.save(enderecoEntity);
            enderecoDTO.setId(enderecoEntity.getId());
        }

        return dto;
    }

    public List<PessoaDTO> listarPessoas() {
        List<PessoaEntity> findAll = pessoaRepository.findAll();
        List<PessoaDTO> pessoas = new ArrayList<>();
        for (PessoaEntity pessoaEntity : findAll) {
            PessoaDTO pessoaDTO = PessoaMapper.entityToDto(pessoaEntity);

            pessoaDTO.setEnderecos(new ArrayList<>());
            for (EnderecoEntity enderecoEntity : pessoaEntity.getEnderecos()) {
                EnderecoDTO enderecoDTO = EnderecoMapper.entityToDto(enderecoEntity);
                pessoaDTO.getEnderecos().add(enderecoDTO);
            }
            pessoas.add(pessoaDTO);
        }
        return pessoas;
    }

    public PessoaDTO buscaPessoaPeloId(Integer id){
        try {
            Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(id);
            PessoaDTO pessoaDTO = PessoaMapper.entityToDto(pessoaEntity.get());
            pessoaDTO.setEnderecos(new ArrayList<>());
            for (EnderecoEntity enderecoEntity : pessoaEntity.get().getEnderecos()) {
                EnderecoDTO enderecoDTO = EnderecoMapper.entityToDto(enderecoEntity);
                enderecoDTO.setIdPessoa(pessoaDTO.getId());
                pessoaDTO.getEnderecos().add(enderecoDTO);
            }
            return pessoaDTO;
        } catch (Exception e) {
            throw new NotFoundException("pessoa nao encontrada");
        }

    }

    public void deletaPessoa(Integer id) {
        try {
            Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);
            for (EnderecoEntity enderecoEntity : pessoa.get().getEnderecos()) {
                enderecoRepository.delete(enderecoEntity);
            }
            pessoaRepository.delete(pessoa.get());
        } catch (Exception e) {
            throw new NotFoundException("Pessoa não encontrada");
        }
    }

    public PessoaDTO atualizaPessoa(Integer id, PessoaDTO dados) {
        try {

            Optional<PessoaEntity> pessoa = pessoaRepository.findById(id);
            pessoa.get().setNome(dados.getNome());
            pessoa.get().setDataDeNascimento(dados.getDataDeNascimento());
            pessoaRepository.save(pessoa.get());
            PessoaDTO pessoaDTO = PessoaMapper.entityToDto(pessoa.get());
            pessoaDTO.setEnderecos(new ArrayList<>());
            for (EnderecoEntity enderecoEntity : pessoa.get().getEnderecos()) {
                EnderecoDTO enderecoDTO = EnderecoMapper.entityToDto(enderecoEntity);
                pessoaDTO.getEnderecos().add(enderecoDTO);
            }
            return pessoaDTO;
        } catch (Exception e) {
            throw new NotFoundException("Pessoa não encontrada");
        }

    }



}