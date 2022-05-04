package com.teste.pessoa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.pessoa.dto.PessoaAtualizarRequest;
import com.teste.pessoa.dto.PessoaInserirResponse;
import com.teste.pessoa.dto.PessoaInserirRequest;
import com.teste.pessoa.entidades.Pessoa;
import com.teste.pessoa.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/pessoa")
public class PessoaController {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>>findAll(){
        List<Pessoa> list =pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa obj = pessoaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<PessoaInserirResponse> insert(@RequestParam String pessoaData,
                                                        @RequestParam("file")final MultipartFile file) throws IOException {
      final var pessoaInserirRequest = mapper.readValue(pessoaData, PessoaInserirRequest.class);
        pessoaInserirRequest.setImagem(file.getInputStream().readAllBytes());
        var pessoa=pessoaService.insert(pessoaInserirRequest);
        var pessoaResponse = new PessoaInserirResponse();
        BeanUtils.copyProperties(pessoa,pessoaResponse);
        return new ResponseEntity<>(pessoaResponse, HttpStatus.CREATED);

    };
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable("id")Long id,
                                         @RequestParam String pessoaData,
                                         @RequestParam(value = "file",required = false)final MultipartFile file )throws IOException{
        final var pessoaAtualizarRequest=mapper.readValue(pessoaData, PessoaAtualizarRequest.class);
        pessoaAtualizarRequest.setImagem(file.getInputStream().readAllBytes());
        var pessoa = pessoaService.update(id,pessoaAtualizarRequest);
        return ResponseEntity.ok().body(pessoa);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
