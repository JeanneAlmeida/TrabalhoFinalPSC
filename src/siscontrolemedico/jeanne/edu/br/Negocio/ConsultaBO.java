/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Negocio;

import java.sql.SQLException;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Consulta;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;
import siscontrolemedico.jeanne.edu.br.Excessao.PesquisaNaoEncontradaException;
import siscontrolemedico.jeanne.edu.br.Persistencia.ConsultaDAO;

/**
 *
 * @author Jeanne
 */
public class ConsultaBO {

    

    public void salvar(Consulta consulta) throws SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.salvar(consulta);
    }

   public List<Consulta> buscarTodos() throws SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        return consultaDAO.buscarTodos();
    }

    public void excluirConsulta(int id) throws SQLException {
 
        ConsultaDAO consultaDAO = new ConsultaDAO();
        consultaDAO.excluirConsulta(id);
    
    }
}
