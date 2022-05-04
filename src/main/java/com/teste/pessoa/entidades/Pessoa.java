package com.teste.pessoa.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Date nascimento;

    @Lob
    private byte[] imagem;

//    public Pessoa(){
//
//    }
//
//    public Pessoa(Long id, String nome, Date nascimento, byte[] imagem) {
//        this.id = id;
//        this.nome = nome;
//        this.nascimento = nascimento;
//        this.imagem = imagem;
//    }
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public Date getNascimento() {
//        return nascimento;
//    }
//
//    public void setNascimento(Date nascimento) {
//        this.nascimento = nascimento;
//    }
//
//    public byte[] getImagem() {
//        return imagem;
//    }
//
//    public void setImagem(byte[] imagem) {
//        this.imagem = imagem;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Pessoa)) return false;
//        Pessoa pessoa = (Pessoa) o;
//        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getNascimento(), pessoa.getNascimento());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getNome(), getNascimento());
//    }
}
