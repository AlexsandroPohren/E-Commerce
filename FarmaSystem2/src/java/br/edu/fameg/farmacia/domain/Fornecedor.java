/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.domain;

/**
 *
 * @author pazak
 */
public class Fornecedor {
    
    private Integer id;
    private String nome;
    private String sobrenome;   
    private Endereco endereco;    
    private Empresa empresa;
    private Contato contato;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String sobrenome, Endereco endereco, Empresa empresa, Contato contato) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.empresa = empresa;
        this.contato = contato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
   
    
    
    
}
