/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.domain.Contato;
import br.edu.fameg.farmacia.domain.Empresa;
import br.edu.fameg.farmacia.domain.Endereco;
import br.edu.fameg.farmacia.domain.Estado;
import br.edu.fameg.farmacia.util.FabricaConexao;
import br.edu.fameg.farmacia.Exception.ErrosSistema;
import com.sun.xml.internal.ws.developer.Serialization;
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
@Serialization
public class EmpresaDAO implements CrudDAO<Empresa> {
    
    @Override
    public void salvar(Empresa empresa) throws ErrosSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (empresa.getId() == null) {
                ps = conexao.prepareCall("INSERT INTO `empresa` (`razaoSocial`,`endereco`,`contato`) VALUES (?,?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE empresa SET razaoSocial=?, endereco=?, contato=? where id=?");
                ps.setInt(4, empresa.getId());
            }
            ps.setString(1, empresa.getRazaoSocial());
            ps.setInt(2, empresa.getEndereco().getId());
            ps.setInt(3, empresa.getContato().getId());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
          throw new ErrosSistema("Erro ao salvar o empresa!", ex);
        }
    }

    @Override
    public void deletar(Empresa empresa) throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from empresa where id = ?");
            ps.setInt(1, empresa.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao deletar o empresa!", ex);
        }
    }
//
    @Override
    public List<Empresa> buscar() throws ErrosSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM empresa");
            ResultSet rs = ps.executeQuery();
            List<Empresa> empresas = new ArrayList<>();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                
                empresa.setRazaoSocial(rs.getString("razaoSocial")); 
                
                Endereco end = new Endereco();                
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));                
                end.setLogradouro(rs.getString("logradouro"));
                empresa.setEndereco(end);                
                
                Estado est = new Estado();                
                est.setNome(rs.getString("nome"));
                est.setSigla(rs.getString("sigla"));
                end.setEstado(est);
                
                Contato con = new Contato();
                con.setCelular(rs.getString("celuar"));
                con.setEmail(rs.getString("email"));
                con.setTelefone(rs.getString("telefone"));
                empresa.setContato(con);
                
                empresas.add(empresa);
            }
            FabricaConexao.fecharConexao();
            return empresas;
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao Listar Produtos!", ex);
        }
    }

}
