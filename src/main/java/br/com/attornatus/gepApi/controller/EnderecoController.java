package br.com.attornatus.gepApi.controller;


import br.com.attornatus.gepApi.dto.EnderecoDTO;
import br.com.attornatus.gepApi.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {
    @Autowired
    public EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid EnderecoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.salvarEndereco(dto));

    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Object> listarEnderecos(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEnderecos(id));

    }

    @PutMapping
    public ResponseEntity<Object> editar(@RequestBody @Valid EnderecoDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.editarEnderecos(dto));

    }
}