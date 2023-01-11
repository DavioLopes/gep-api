package br.com.attornatus.gepApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Integer id;

    private String logadouro;

    private String cep;

    private String numero;

    private String cidade;

    private Boolean principal;

    @NotNull
    private Integer idPessoa;

}
