/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Negocio;

import java.sql.SQLException;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Prontuario;
import siscontrolemedico.jeanne.edu.br.Persistencia.ConsultaDAO;
import siscontrolemedico.jeanne.edu.br.Persistencia.ProntuarioDAO;

/**
 *
 * @author Jeanne
 */
public class ProntuarioBO {
    
    public static void salvar(Prontuario prontuarioo) throws SQLException {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        prontuarioDAO.salvar(prontuarioo);
    }

    public List<Prontuario> buscarTodos() throws SQLException {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();
        return prontuarioDAO.buscarTodos();
    }

}
