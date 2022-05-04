package com.teste.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaAtualizarRequest {
    private Long id;
    private String nome;
    private Date nascimento;
    private byte[] imagem;


}
