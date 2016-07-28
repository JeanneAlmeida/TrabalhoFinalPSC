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
import siscontrolemedico.jeanne.br.eu.Entidade.Consulta;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;

/**
 *
 * @author Jeanne
 */
public class ConsultaDAO {
    private static final String INSERT = "INSERT INTO AGENDARCONSULTA (PACIENTE, DATA, HORA, MEDICO) VALUES (?, ?, ?, ?)";
    private static final String BUSCARCONSULTAS = "SELECT * FROM AGENDARCONSULTA ORDER BY DATA DESC , MEDICO";
    private static final String DATA = "SELECT * FROM AGENDARCONSULTA WHERE DATA = ?";
    private static final String DELETE = "DELETE FROM AGENDARCONSULTA WHERE ID=?";
    private static final String ALTERAR= "UPDATE AGENDARCONSULTA SET PACIENTE=?, DATA=?, HORA=?,MEDICO=? WHERE ID=?";
  
    static List<Consulta> listaConsulta = new ArrayList<>();  

    private static Consulta Pesquisar(ResultSet resultado) throws SQLException {
      Consulta consulta = new Consulta();

                consulta.setId(resultado.getInt(1));
                for (Paciente paciente : PacienteDAO.buscarPaciente()) {
                    if (paciente.getId() == resultado.getInt(2)) {
                        consulta.setPaciente(paciente);
                    }
                }
        return (Consulta) listaConsulta;
    }

    
    public void salvar(Consulta consulta) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT);
            comando.setInt(1,consulta.getPaciente().getId());
            java.sql.Date dataSql = new java.sql.Date(consulta.getData().getTime());
            comando.setDate(2, dataSql);
            comando.setTime(3, consulta.getHorario());
            comando.setInt(4,consulta.getUsuario().getId());
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
    
    public List<Consulta> buscarTodos() throws SQLException {
      
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
             
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement(BUSCARCONSULTAS);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Consulta funcionario = ConsultaDAO.extrairLinhaResultado(resultado);
               listaConsulta.add(funcionario);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaConsulta;
    }
    
    static List<Consulta> buscarTodos2() throws SQLException {
      
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
             
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement(BUSCARCONSULTAS);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Consulta funcionario = ConsultaDAO.extrairLinhaResultado(resultado);
               listaConsulta.add(funcionario);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaConsulta;
    }
    
    static Consulta extrairLinhaResultado(ResultSet resultado) throws SQLException {
      
        Consulta consulta = new Consulta();

                consulta.setId(resultado.getInt(1));
                for (Paciente paciente : PacienteDAO.buscarTodos()) {
                    if (paciente.getId() == resultado.getInt(2)) {
                        consulta.setPaciente(paciente);
                    }
                }
                consulta.setData(resultado.getDate(3));
                consulta.setHorario(resultado.getTime(4));
                for (Usuario medico : UsuarioDAO.buscarTodos()) {
                    if (medico.getId() == resultado.getInt(5)) {
                        consulta.setUsuario(medico);
                    }
                }
                listaConsulta.add(consulta);     
        return consulta;
    }
    
    public void excluirConsulta(int id) throws SQLException {
         Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(DELETE);
            comando.setInt(1, id);

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
