/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.AtendenteDAO;
import br.edu.fameg.farmacia.domain.Atendente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pazak
 *
 */
@ManagedBean
@SessionScoped
public class AtendenteBean extends CrudBean<Atendente, AtendenteDAO> {

    private AtendenteDAO atendenteDAO;

    @Override
    public AtendenteDAO getDAO() {
        if (atendenteDAO == null) {
            atendenteDAO = new AtendenteDAO();
        }
        return atendenteDAO;
    }

    @Override
    public Atendente criarNovaEntidade() {
        return new Atendente();
    }

}
