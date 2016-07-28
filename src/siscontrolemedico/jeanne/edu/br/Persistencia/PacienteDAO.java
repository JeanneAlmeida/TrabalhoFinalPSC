/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;

/**
 *
 * @author Jeanne
 */
public class PacienteDAO {
     private static final String INSERT = "INSERT INTO PACIENTE (NOME,CPF,RG,TELEFONE,ENDERECO) VALUES (? , ?, ?, ?,?)";
     private static final String NOME = "SELECT * FROM PACIENTE WHERE NOME = ?";
     private static final String DELETE = "DELETE FROM PACIENTE WHERE NOME=?";
     private static final String UPDATE = "UPDATE PACIENTE SET NOME =?, CPF = ?, RG = ?,TELEFONE = ?, ENDERECO = ? WHERE ID =? ";
     private static final String PESQUISAR_CPFeXISTENTE = "SELECT NOME, CPF, RG, TELEFONE, ENDERECO FROM PACIENTE WHERE CPF= ? ";
     private static final String PESQUISAR_RG_EXISTENTE = "SELECT NOME, CPF, RG, TELEFONE, ENDERECO FROM PACIENTE WHERE RG= ? ";
      private static final String BUSCAR_Paciente = "SELECT * FROM PACIENTE"; 
      private static final String ALTERAR = "UPDATE PACIENTE SET  NOME=?,CPF=?, RG=?, TELEFONE=?, ENDERECO=? WHERE ID = ?";
       private static final String BUSCARporPaciente =   "SELECT PACIENTE.NOME \n" +
"  FROM AGENDARCONSULTA\n" +
"  JOIN PACIENTE  ON PACIENTE.ID= AGENDARCONSULTA.PACIENTE WHERE PACIENTE.NOME =";
    public static void alterar(Paciente pacientes) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(ALTERAR);        
            comando.setString(1, pacientes.getNome());
            comando.setString(2, pacientes.getCpf());
            comando.setString(3, pacientes.getRg());
            comando.setString(4, pacientes.getTelefone());
            comando.setString(5, pacientes.getEndereco());
            comando.setInt(6, pacientes.getId());
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

    static Iterable<Paciente> buscarPaciente() throws SQLException {
         List<Paciente> pacientes = new ArrayList<>();
         Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(BUSCARporPaciente);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                paciente = new Paciente();
               
                paciente.setId(resultado.getInt(1));
                paciente.setNome(resultado.getString(2));
                paciente.setCpf(resultado.getString(3));
                paciente.setRg(resultado.getString(4));
                paciente.setTelefone(resultado.getString(5));
                paciente.setEndereco(resultado.getString(6));
                
               pacientes.add(paciente);
            }
        } catch (Exception e) {
            if (conexao == null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
         return pacientes;
    }
     public void inserir(Paciente pacientes) throws SQLException {
       Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT);
            comando.setString(1, pacientes.getNome());
            comando.setString(2, pacientes.getCpf());
            comando.setString(3, pacientes.getRg());
            comando.setString(4, pacientes.getTelefone());
            comando.setString(5, pacientes.getEndereco());
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

    public Paciente pesquisarLogin(String nome) throws SQLException {
        Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(NOME);
            comando.setString(1, nome);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                paciente = new Paciente();
                paciente.setId(resultado.getInt(1));
                paciente.setNome(resultado.getString(2));
                paciente.setCpf(resultado.getString(3));
                paciente.setRg(resultado.getString(4));
                paciente.setTelefone(resultado.getString(5));
                paciente.setEndereco(resultado.getString(6));
            }
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return paciente;
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

    public void alterarPaciente(Paciente pacientes) throws SQLException {
        
    }

    public Paciente VerificarCPF(String cpf) throws SQLException {
       Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(PESQUISAR_CPFeXISTENTE);
            comando.setString(1, cpf);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                paciente = new Paciente();
                
                paciente.setId(resultado.getInt(1));
                paciente.setNome(resultado.getString(2));
                paciente.setCpf(resultado.getString(3));
                paciente.setRg(resultado.getString(4));
                 paciente.setTelefone(resultado.getString(5));
                paciente.setEndereco(resultado.getString(6));
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return paciente;
    }

    public Paciente VerificarRG(String cpf) throws SQLException {
         Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(PESQUISAR_RG_EXISTENTE);
            comando.setString(1, cpf);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                paciente = new Paciente();
                
                paciente.setId(resultado.getInt(1));
                paciente.setNome(resultado.getString(2));
                paciente.setCpf(resultado.getString(3));
                paciente.setRg(resultado.getString(4));
                 paciente.setTelefone(resultado.getString(5));
                paciente.setEndereco(resultado.getString(6));
            }

        }catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return paciente;
    }

    static Iterable<Paciente> buscarTodos() throws SQLException {
         List<Paciente> pacientes = new ArrayList<>();
         Paciente paciente = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(BUSCAR_Paciente);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                paciente = new Paciente();
               
                paciente.setId(resultado.getInt(1));
                paciente.setNome(resultado.getString(2));
                paciente.setCpf(resultado.getString(3));
                paciente.setRg(resultado.getString(4));
                paciente.setTelefone(resultado.getString(5));
                paciente.setEndereco(resultado.getString(6));
                
               pacientes.add(paciente);
            }

        } catch (Exception e) {
            if (conexao != null) {
//                conexao.rollback();
            }
//            throw new RuntimeException();
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return pacientes;
    }
}
