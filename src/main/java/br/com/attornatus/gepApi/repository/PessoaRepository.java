package br.com.attornatus.gepApi.repository;

import br.com.attornatus.gepApi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {


}
