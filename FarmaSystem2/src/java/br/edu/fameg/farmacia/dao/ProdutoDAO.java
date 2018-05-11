package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.domain.Produto;
import br.edu.fameg.farmacia.Exception.ErrosSistema;
import br.edu.fameg.farmacia.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo Souza Almeida
 */
public class ProdutoDAO implements CrudDAO<Produto>{
    
    @Override
    public void salvar(Produto produto) throws ErrosSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps; 
            if(produto.getId() == null){
                ps = conexao.prepareCall("INSERT INTO `produto` (`nome`,`fabricante`,`categoria`,`valor`) VALUES (?,?,?,?)");
            }else{
                ps = conexao.prepareStatement("UPDATE produto SET nome=?, fabricante=?, categoria=?, valor=? where id=?");
                ps.setInt(5, produto.getId());
            }
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getFabricante());
            ps.setString(3, produto.getCategoria());
            ps.setDouble(4, produto.getValor());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao salvar o produto!", ex);  
        }
        
    }
    @Override
    public List<Produto> buscar() throws ErrosSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produto");
            ResultSet resultSet = ps.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setFabricante(resultSet.getString("fabricante"));
                produto.setCategoria(resultSet.getString("categoria"));
                produto.setValor(resultSet.getDouble("valor"));
                produtos.add(produto);
            }
            FabricaConexao.fecharConexao();
            return produtos;
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao listar produtos!", ex);           
        }        
    }
    
    @Override
    public void deletar(Produto produto) throws ErrosSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM produto WHERE id = ?");
            ps.setInt(1, produto.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao deletar produto!", ex);
        }
            
        }
}
