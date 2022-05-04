package com.teste.porto.service;

import com.teste.porto.entidades.Pessoa;
import com.teste.porto.repository.PessoaRepository;
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
        public Pessoa update (Long id, Pessoa obj){
            Pessoa entity = pessoaRepository.getOne(id);
            updateData(entity, obj);
            return pessoaRepository.save(entity);

        }
    private void updateData(Pessoa entity, Pessoa obj){
        entity.setNome(obj.getNome());
        entity.setNascimento(obj.getNascimento());
        }

    public Pessoa insert (Pessoa obj){
        return pessoaRepository.save(obj);
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }


    }
