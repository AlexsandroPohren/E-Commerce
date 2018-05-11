/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.dao;

import br.edu.fameg.farmacia.domain.Usuario;
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
 * @author pazak
 */
public class UsuarioDAO implements CrudDAO<Usuario> {

    @Override
    public void salvar(Usuario entidade) throws ErrosSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps; 
            if(entidade.getId() == null){
                ps = conexao.prepareCall("INSERT INTO `usuario` (`login`,`senha`) VALUES (?,?)");
            }else{
                ps = conexao.prepareStatement("UPDATE usuario SET login=?, senha=? where id=?");
                ps.setInt(3, entidade.getId());
            }
            ps.setString(1, entidade.getLogin());
            ps.setString(2, entidade.getSenha());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao tentar salvar", ex);
        }
    }

    @Override
    public void deletar(Usuario entidade) throws ErrosSistema {
       try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao deletar objeto!", ex);
        }}

    @Override
    public List<Usuario> buscar() throws ErrosSistema {
     try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM usuario");
            ResultSet resultSet = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
               
                usuarios.add(usuario);
            }
            FabricaConexao.fecharConexao();
            return usuarios;
        } catch (SQLException ex) {
            throw new ErrosSistema("Erro ao Salvar!", ex);           
        }        
    }

 
    
}
