package br.edu.fameg.farmacia.util;

import br.edu.fameg.farmacia.Exception.ErrosSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danilo Souza Almeida
 */
public class FabricaConexao {
    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/farmasystem";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConexao() throws ErrosSistema {
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                throw new ErrosSistema("Não foi possivel conectar ao banco de dados!", ex);
            } catch (ClassNotFoundException ex) {
                throw new ErrosSistema("O driver do BD não foi encontrado!", ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao()throws ErrosSistema{
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErrosSistema("Erro ao fechar conexão com BD ", ex);
            }
        }
    }
    
    
}
