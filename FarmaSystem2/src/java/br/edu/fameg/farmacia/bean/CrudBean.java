/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.CrudDAO;
import br.edu.fameg.farmacia.Exception.ErrosSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author pazak
 */
public abstract class CrudBean<E, D extends CrudDAO> {
    
    private String estadoTela = "buscar"; // Inserir, editar, Buscar
    
    
    private E entidade;
    private List<E> entidades;
    
    public void novo(){
        entidade = criarNovaEntidade();
        mudarParaInseri();
    }
    public void salvar(){
        try {
            getDAO().salvar(entidade);
            entidade = criarNovaEntidade();
            adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
            mudarParaBusca();
        } catch (ErrosSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void editar(E entidade){
        this.entidade = entidade;
        mudarParaEdita();
    }
    public void deletar(E entidade){
        try {
            getDAO().deletar(entidade);
            entidades.remove(entidade);
            adicionarMensagem("Removido com sucesso!", FacesMessage.SEVERITY_INFO);
           
        } catch (ErrosSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        
        }
        
    }
    public void buscar(){
        if(isBusca() == false){
            mudarParaBusca();
            return;
        }
        try {
            entidades = getDAO().buscar();
            if(entidades == null || entidades.size() < 1){
                adicionarMensagem("Não existem objetos cadastrados", FacesMessage.SEVERITY_WARN);
        
            }
        } catch (ErrosSistema ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMensagem(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        
        }
    }
    
    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro){
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    //getter e setter

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    //Responsavel por criar os metodos nas classes bean
    public abstract D getDAO();
    public abstract E criarNovaEntidade();
        
    public boolean isInseri(){
        return "inserir".equals(estadoTela);
    }
    public boolean isEdita(){
        return "editar".equals(estadoTela);
    }
    public boolean isBusca(){
        return "buscar".equals(estadoTela);
    }    
    public void mudarParaInseri(){
        estadoTela = "inserir";
    }    
    public void mudarParaEdita(){
        estadoTela = "editar";
    }    
    public void mudarParaBusca(){
        estadoTela = "buscar";
    }
}
