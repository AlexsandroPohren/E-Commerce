/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.domain.Atendente;
import br.edu.fameg.farmacia.domain.Contato;
import br.edu.fameg.farmacia.domain.Endereco;
import br.edu.fameg.farmacia.domain.Estado;
import br.edu.fameg.farmacia.domain.Usuario;
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
 public class AtendenteDAO implements CrudDAO<Atendente> {

    @Override
    public void salvar(Atendente atendente) throws ErrosSistema {
         try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (atendente.getId() == null) {
                ps = conexao.prepareCall("INSERT INTO `atendente` (`nome`,`sobrenome`,`cpf`, `usuario`, `endereco`, `contato`) VALUES (?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("UPDATE atendente SET nome=?, sobrenome=?, cpf=?, usuario=?, endereco=?, contato=? where id=?");
                ps.setInt(7, atendente.getId());
            }
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getSobrenome());
            ps.setString(3, atendente.getCpf());
            ps.setInt(4, atendente.getUsuario().getId());
            ps.setInt(5, atendente.getEndereco().getId());
            ps.setInt(6, atendente.getContato().getId());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
          throw new ErrosSistema("Erro ao salvar o atendente!", ex);
        }
    }

    @Override
    public void deletar(Atendente entidade) throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from entidade where id = ?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao deletar o atendente!", ex);
        }}

    @Override
    public List<Atendente> buscar() throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM atendente");
            ResultSet rs = ps.executeQuery();
            List<Atendente> atendentes = new ArrayList<>();
            while (rs.next()) {
                Atendente atendente = new Atendente();
                
                atendente.setNome(rs.getString("nome")); 
                atendente.setSobrenome(rs.getString("sobrenome"));
                atendente.setCpf(rs.getString("cpf"));
                
                Usuario usr = new Usuario();
                usr.setLogin(rs.getString("login"));
                usr.setSenha(rs.getString("senha"));
                usr.setTipo(rs.getString("tipo"));
                atendente.setUsuario(usr);
                
                Endereco end = new Endereco();                
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));                
                end.setLogradouro(rs.getString("logradouro"));
                atendente.setEndereco(end);                
                
                Estado est = new Estado();                
                est.setNome(rs.getString("nome"));
                est.setSigla(rs.getString("sigla"));
                end.setEstado(est);
                
                Contato con = new Contato();
                con.setCelular(rs.getString("celuar"));
                con.setEmail(rs.getString("email"));
                con.setTelefone(rs.getString("telefone"));
                atendente.setContato(con);
                
                atendentes.add(atendente);
            }
            FabricaConexao.fecharConexao();
            return atendentes;
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao Listar Produtos!", ex);
        }}
    
    
    
}
