/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.FornecedorDAO;
import br.edu.fameg.farmacia.domain.Fornecedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pazak
 */

@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorBean extends CrudBean<Fornecedor, FornecedorDAO> {
    
    private FornecedorDAO fornecedorDAO;
    
    @Override
    public FornecedorDAO getDAO() {
      if(fornecedorDAO == null){
            fornecedorDAO = new FornecedorDAO();
        }
        return fornecedorDAO;}

    @Override
    public Fornecedor criarNovaEntidade() {
       return new Fornecedor();
    }    
}
