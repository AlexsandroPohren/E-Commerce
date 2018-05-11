/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.EmpresaDAO;
import br.edu.fameg.farmacia.domain.Empresa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pazak
 */
@ManagedBean
@SessionScoped
public class EmpresaBean extends CrudBean<Empresa, EmpresaDAO> {

    private EmpresaDAO empresaDAO;
    
    @Override
    public EmpresaDAO getDAO() {
        if(empresaDAO == null){
            empresaDAO = new EmpresaDAO();
        }
        return empresaDAO;
    }

    @Override
    public Empresa criarNovaEntidade() {
       return new Empresa();               
    }
    
    
    
}
