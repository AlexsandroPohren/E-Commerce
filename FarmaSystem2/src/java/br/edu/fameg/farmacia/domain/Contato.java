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
public class Contato{
    
    private Integer id;
    private String email;
    private String telefone;
    private String celular;

    public Contato() {
    }

    public Contato(String email, String telefone, String celular) {
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

  
    
}
