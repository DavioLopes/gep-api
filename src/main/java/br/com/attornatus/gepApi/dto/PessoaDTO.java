package br.com.attornatus.gepApi.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String dataDeNascimento;

    private List<EnderecoDTO> enderecos;

}
