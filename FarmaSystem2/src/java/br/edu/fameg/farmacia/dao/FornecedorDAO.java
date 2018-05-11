/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.domain.Contato;
import br.edu.fameg.farmacia.domain.Endereco;
import br.edu.fameg.farmacia.domain.Estado;
import br.edu.fameg.farmacia.domain.Fornecedor;
import br.edu.fameg.farmacia.util.FabricaConexao;
import br.edu.fameg.farmacia.Exception.ErrosSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pazak
 */
public class FornecedorDAO implements CrudDAO<Fornecedor>{

    @Override
    public void salvar(Fornecedor fornecedor) throws ErrosSistema {
       try {

            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (fornecedor.getId() == null) {
                ps = conexao.prepareCall("INSERT INTO fornecedor (nome,sobrenome,endereco,empresa,contato,) VALUES (?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE fornecedor SET nome=?, sobrenome=?, endereco=?, contato=?, empresa=? where id=?");
                ps.setInt(6, fornecedor.getId());
            }
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getSobrenome());
            ps.setInt(3, fornecedor.getEndereco().getId());
            ps.setInt(4, fornecedor.getEmpresa().getId());
            ps.setInt(5, fornecedor.getContato().getId());    
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao salvar fornecedor", ex);
        }
    }

    @Override
    public void deletar(Fornecedor fornecedor) throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from fornecedor where id = ?");
            ps.setInt(1, fornecedor.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao deletar o fornecedor!", ex);
        }
    }

    @Override
    public List<Fornecedor> buscar() throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM fornecedor");
            ResultSet rs = ps.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setNome(rs.getString("nome")); 
                
                Endereco end = new Endereco();                
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));                
                end.setLogradouro(rs.getString("logradouro"));
                fornecedor.setEndereco(end);                
                
                Estado est = new Estado();                
                est.setNome(rs.getString("nome"));
                est.setSigla(rs.getString("sigla"));
                end.setEstado(est);
                
                Contato con = new Contato();
                con.setCelular(rs.getString("celular"));
                con.setEmail(rs.getString("email"));
                con.setTelefone(rs.getString("telefone"));
                fornecedor.setContato(con);
                
                fornecedores.add(fornecedor);
            }
            FabricaConexao.fecharConexao();
            return fornecedores;
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao Listar Fornecedores!", ex);
        } }
    
    
    
}
