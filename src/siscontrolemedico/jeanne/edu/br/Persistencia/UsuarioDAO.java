
package siscontrolemedico.jeanne.edu.br.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;

/**
 *
 * @author Jeanne
 */
public class UsuarioDAO {
     private static final String INSERT = "INSERT INTO USUARIO (NOME, CPF, RG, TELEFONE, ENDERECO, SEXO, LOGIN, SENHA, CARGO, ICRM) VALUES (?,?,?,?,?,?,?,?,?,?)";
     private static final String LOGIN_SELECT = "SELECT ID, NOME,LOGIN, SENHA, CARGO FROM USUARIO WHERE LOGIN = ?"; 
     private static final String NOME = "SELECT * FROM \"PUBLIC\".\"USUARIO\" WHERE NOME = ?";
     private static final String DELETE = "DELETE FROM USUARIO WHERE NOME=?";
     private static final String UPDATE = "UPDATE USUARIO SET NOME = ? , CPF = ?, RG = ?, TELEFONE = ?, ENDERECO = ?, SEXO =?, LOGIN = ?, SENHA = ?, CARGO = ?, ICRM = ? WHERE ID = ?";
     private static final String PESQUISAR_cpf_EXISTENTE = "SELECT NOME, CPF, RG, TELEFONE, ENDERECO, SEXO, LOGIN, SENHA, CARGO, ICRM FROM USUARIO WHERE CPF= ? ";
     private static final String PESQUISAR_RG_EXISTENTE = "SELECT NOME, CPF, RG, TELEFONE, ENDERECO, SEXO, LOGIN, SENHA, CARGO, ICRM FROM USUARIO WHERE RG = ? ";
     private static final String PESQUISAR_LOGIN_EXISTENTE = "SELECT NOME, CPF, RG, TELEFONE, ENDERECO, SEXO, LOGIN, SENHA, CARGO, ICRM FROM USUARIO WHERE LOGIN = ? ";
     private static final String BUSCAR_Usuarios = "SELECT * FROM USUARIO";
     private static final String ALTERAR = "UPDATE USUARIO SET  NOME=?,CPF=?, RG=?, TELEFONE=?, ENDERECO=?, SEXO=?, LOGIN =?, SENHA = ?, CARGO=?, ICRM=? WHERE ID = ?";
     
     static Iterable<Usuario> buscarTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
         Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(BUSCAR_Usuarios);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                usuario = new Usuario();
               
                usuario.setId(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setRg(resultado.getString(4));
                usuario.setTelefone(resultado.getString(5));
                usuario.setEndereco(resultado.getString(6));
                usuario.setSexo(resultado.getString(7));
                usuario.setLogin(resultado.getString(8));
                usuario.setSenha(resultado.getString(9));
                usuario.setCargo(resultado.getString(10));
                usuario.setIcrm(resultado.getString(11));
               usuarios.add(usuario);
            }

        } catch (Exception e) {
            if (conexao != null) {
                   conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return usuarios;
    }

     public void inserir(Usuario usuarios) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT);
            comando.setString(1, usuarios.getNome());
            comando.setString(2, usuarios.getCpf());
            comando.setString(3, usuarios.getRg());
            comando.setString(4, usuarios.getTelefone());
            comando.setString(5, usuarios.getEndereco());
            comando.setString(6, usuarios.getSexo());
            comando.setString(7, usuarios.getLogin());
            comando.setString(8, usuarios.getSenha());
            comando.setString(9, usuarios.getCargo());
            comando.setString(10, usuarios.getIcrm());
            
            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao == null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public Usuario buscarLogin(Usuario usuario) throws SQLException {
        Usuario usuarios = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(LOGIN_SELECT);
            comando.setString(1, usuario.getLogin());   
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                usuarios = new Usuario();
                usuarios.setId(resultado.getInt(1));
                usuarios.setNome(resultado.getString(2));
                usuarios.setLogin(resultado.getString(3));
                usuarios.setSenha(resultado.getString(4));  
                usuarios.setCargo(resultado.getString(5));
            }        
        }finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return usuarios;
    }

    public Usuario pesquisarLogin(String nome) throws SQLException {
        Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(NOME);
            comando.setString(1, nome);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setRg(resultado.getString(4));
                usuario.setTelefone(resultado.getString(5));
                usuario.setEndereco(resultado.getString(6));
                usuario.setSexo(resultado.getString(7));
                usuario.setLogin(resultado.getString(8));
                usuario.setSenha(resultado.getString(9));
                usuario.setCargo(resultado.getString(10));
                usuario.setIcrm(resultado.getString(11));
            }
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }

    public void excluir(String nome) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(DELETE);        
            comando.setString(1, nome);
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

    public Usuario VerificarCPF(String cpf) throws SQLException {
       Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(PESQUISAR_cpf_EXISTENTE);
            comando.setString(1, cpf);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();
                
                usuario.setId(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setRg(resultado.getString(4));
                usuario.setTelefone(resultado.getString(5));
                usuario.setEndereco(resultado.getString(6));
                usuario.setSexo(resultado.getString(7));
                usuario.setLogin(resultado.getString(8));
                usuario.setSenha(resultado.getString(9));
                usuario.setCargo(resultado.getString(10));
                usuario.setIcrm(resultado.getString(11));
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }

    public Usuario VerificarRG(String rg) throws SQLException {
       Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(PESQUISAR_RG_EXISTENTE);
            comando.setString(1, rg);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();
                
                usuario.setId(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setRg(resultado.getString(4));
                usuario.setTelefone(resultado.getString(5));
                usuario.setEndereco(resultado.getString(6));
                usuario.setSexo(resultado.getString(7));
                usuario.setLogin(resultado.getString(8));
                usuario.setSenha(resultado.getString(9));
                usuario.setCargo(resultado.getString(10));
                usuario.setIcrm(resultado.getString(11));
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }

    public Usuario VerificarLogin(String login) throws SQLException {
        Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(PESQUISAR_LOGIN_EXISTENTE);
            comando.setString(1, login);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                usuario = new Usuario();
                
                usuario.setId(resultado.getInt(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCpf(resultado.getString(3));
                usuario.setRg(resultado.getString(4));
                usuario.setTelefone(resultado.getString(5));
                usuario.setEndereco(resultado.getString(6));
                usuario.setSexo(resultado.getString(7));
                usuario.setLogin(resultado.getString(8));
                usuario.setSenha(resultado.getString(9));
                usuario.setCargo(resultado.getString(10));
                usuario.setIcrm(resultado.getString(11));
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuario;
    }

    public Usuario buscarTodos(String palavraPesquisada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> buscarMedico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterar(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(ALTERAR);        
           comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getCpf());
            comando.setString(3, usuario.getRg());
            comando.setString(4, usuario.getTelefone());
            comando.setString(5, usuario.getEndereco());
            comando.setString(6, usuario.getSexo());
            comando.setString(7, usuario.getLogin());
            comando.setString(8, usuario.getSenha());
            comando.setString(9, usuario.getCargo());
            comando.setString(10, usuario.getIcrm());
            comando.setInt(11, usuario.getId());
            comando.execute();
            conexao.commit();
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }

}
