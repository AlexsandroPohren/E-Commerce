package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.ProdutoDAO;
import br.edu.fameg.farmacia.domain.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoDAO> {

    private ProdutoDAO produtoDAO;
        
    @Override
    public ProdutoDAO getDAO() {
        if(produtoDAO == null){
            produtoDAO = new ProdutoDAO();
        }
        return produtoDAO;
    }

    @Override
    public Produto criarNovaEntidade() {
        return new Produto();
    }

}
