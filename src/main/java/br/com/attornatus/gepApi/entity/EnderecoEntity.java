package br.com.attornatus.gepApi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String logadouro;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false)
    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoa;


}