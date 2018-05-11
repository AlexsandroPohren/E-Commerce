/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.UsuarioDAO;
import br.edu.fameg.farmacia.domain.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pazak
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioDAO>{

    private UsuarioDAO usuarioDAO;
    
    @Override
    public UsuarioDAO getDAO() {
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
        }
         return usuarioDAO;
    }

    @Override
    public Usuario criarNovaEntidade() {
        return new Usuario();
    }
    
}
