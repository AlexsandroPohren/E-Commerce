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
public class Empresa {
    
    private Integer id;
    private String razaoSocial;
    private Endereco endereco;
    private Contato contato;

    public Empresa() {
    }
  
    
    public Empresa(String razaoSocial, Endereco endereco, Contato contato) {
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.contato = contato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    
    
    
    
}
