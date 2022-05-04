package com.teste.porto.resources;

import com.teste.porto.entidades.Pessoa;
import com.teste.porto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaResource {

    private static String caminhoImagens="C:\\Users\\mathe\\Documents\\imagens/";

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
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj,
                                         @RequestParam("file")MultipartFile arquivo) {

      try{
        if(!arquivo.isEmpty()) {
            byte[] bytes = arquivo.getBytes();
            Path caminho = Paths.get(caminhoImagens + String.valueOf(obj.getId())+arquivo.getOriginalFilename());
            Files.write(caminho ,bytes);
            obj.setImagem(String.valueOf(obj.getId())+arquivo.getOriginalFilename());
            obj = pessoaService.insert(obj);
        }

    }catch (IOException e){
          e.printStackTrace();
      }
        return ResponseEntity.ok().body(obj);
    };
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj){
        obj = pessoaService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
