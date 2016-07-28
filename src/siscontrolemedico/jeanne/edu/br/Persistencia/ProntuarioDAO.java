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
import java.util.Iterator;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Consulta;
import siscontrolemedico.jeanne.br.eu.Entidade.Prontuario;


/**
 *
 * @author Jeanne
 */
public class ProntuarioDAO {
    private static final String INSERT = "INSERT INTO PRONTUARIO (CONSULTA, PRONTUARIO) VALUES (?, ?)";
    private static final String BUSCARPRONTUARIO = "SELECT * FROM PRONTUARIO ";
    
    List<Prontuario> listaprontuario = new ArrayList<>(); 

    public void salvar(Prontuario prontuarioo) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT);
            comando.setInt(1,prontuarioo.getConsulta().getId());
            comando.setString(2,prontuarioo.getProntuario());
            
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

    public List<Prontuario> buscarTodos() throws SQLException {
      
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;      
             
        try{
            conexao = BancoDadosUtil.getConnection();
            
            comando = conexao.prepareStatement(BUSCARPRONTUARIO);
            resultado = comando.executeQuery();
            while(resultado.next()){
               Prontuario prontuario = this.extrairLinhaResultado(resultado);
               listaprontuario.add(prontuario);
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
            return listaprontuario;
    }
    
    private Prontuario extrairLinhaResultado(ResultSet resultado) throws SQLException {
      
        Prontuario prontuario = new Prontuario();
        prontuario.setId(resultado.getInt(1));
        
        for (Consulta consulta : ConsultaDAO.buscarTodos2()) {
            if (consulta.getId() == resultado.getInt(2)) {
                prontuario.setConsulta(consulta);
            }
        }
       prontuario.setProntuario(resultado.getString(3));
                listaprontuario.add(prontuario);     
        return prontuario;
    }
  
    
}
