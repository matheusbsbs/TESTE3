package com.teste.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaInserirResponse {
    private String nome;
    private Date nascimento;

}
