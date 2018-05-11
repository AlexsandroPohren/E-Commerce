/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.Exception.ErrosSistema;
import java.util.List;

/**
 *
 * @author pazak
 */
public interface CrudDAO<E> { // E representa a entidade
    
    public void salvar(E entidade) throws ErrosSistema;
    
    public void deletar(E entidade) throws ErrosSistema;
    
    public List<E> buscar() throws ErrosSistema;
    
}
