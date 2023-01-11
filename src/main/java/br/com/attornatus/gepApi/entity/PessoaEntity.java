package br.com.attornatus.gepApi.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Table(name = "Pessoa")
@NoArgsConstructor
@Getter
@Setter
public class PessoaEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 12)
    private String dataDeNascimento;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<EnderecoEntity> enderecos;


}