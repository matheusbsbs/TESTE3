package com.teste.pessoa.service;

import com.teste.pessoa.dto.PessoaAtualizarRequest;
import com.teste.pessoa.dto.PessoaInserirRequest;
import com.teste.pessoa.entidades.Pessoa;
import com.teste.pessoa.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){return pessoaRepository.findAll();}



    public Pessoa findById(Long id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.get();
    }
        public Pessoa update (Long id, PessoaAtualizarRequest obj){
            var entity = pessoaRepository.getById(id);
            BeanUtils.copyProperties(obj,entity);
            entity.setId(id);
            pessoaRepository.save(entity);
            return entity;

        }
    private void updateData(Pessoa entity, Pessoa obj){
        entity.setNome(obj.getNome());
        entity.setNascimento(obj.getNascimento());
        }

//    public Pessoa insert (Pessoa obj){
//        return pessoaRepository.save(obj);
//    }
    public Pessoa insert(PessoaInserirRequest pessoaRequest){
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaRequest,pessoa);
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }




    }
