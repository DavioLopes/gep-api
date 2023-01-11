package br.com.attornatus.gepApi.controller;

import static org.springframework.http.HttpStatus.OK;

import br.com.attornatus.gepApi.dto.PessoaDTO;
import br.com.attornatus.gepApi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    public PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPessoa(dto));
    }

    @GetMapping
    public ResponseEntity<Object> listarPessoas() {
        return ResponseEntity.status(OK).body(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscaPessoaPeloId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable(value = "id") Integer id) {
        pessoaService.deletaPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa excluida com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
                                            @RequestBody @Valid PessoaDTO dados) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizaPessoa(id, dados));

    }
}