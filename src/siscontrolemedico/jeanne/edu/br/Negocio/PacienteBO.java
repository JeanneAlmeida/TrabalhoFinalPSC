/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Negocio;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;
import siscontrolemedico.jeanne.edu.br.Excessao.CampoObrigatorioException;
import siscontrolemedico.jeanne.edu.br.Excessao.CpfExisteException;
import siscontrolemedico.jeanne.edu.br.Excessao.PesquisaNaoEncontradaException;
import siscontrolemedico.jeanne.edu.br.Excessao.RgExisteException;
import siscontrolemedico.jeanne.edu.br.Persistencia.PacienteDAO;

/**
 *
 * @author Jeanne
 */
public class PacienteBO {

    public void inserir(Paciente pacientes) throws SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        this.VerificarCPF(pacientes);
        this.VerificarRG(pacientes);
        pacienteDAO.inserir(pacientes);
    }
    
    public Paciente pesquisar(Paciente pacientePesquisado) throws SQLException {
        Paciente pacienteAtual = null;
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteAtual = pacienteDAO.pesquisarLogin(pacientePesquisado.getNome());
        if(pacienteAtual != null){
            return pacienteAtual;
        }else{
            throw new PesquisaNaoEncontradaException();
        }
    }

    public void excluir(String nome) throws SQLException {
      PacienteDAO pacienteDAO = new PacienteDAO();
      pacienteDAO.excluir(nome);
    }

    public void alterarPaciente(Paciente pacientes) throws SQLException {
       
    }

    private void VerificarCPF(Paciente pacientes) throws SQLException {
        Paciente cpfPacienteExistente = null;
        PacienteDAO pacienteDAO = new PacienteDAO();
        cpfPacienteExistente = pacienteDAO.VerificarCPF(pacientes.getCpf());
        if (cpfPacienteExistente != null) {
            throw new CpfExisteException();
        }
    }

    private void VerificarRG(Paciente pacientes) throws SQLException {
        Paciente rgPacienteExistente = null;
        PacienteDAO pacienteDAO = new PacienteDAO();
        rgPacienteExistente = pacienteDAO.VerificarRG(pacientes.getRg());
        if(rgPacienteExistente != null) {
            throw new RgExisteException();
        }
    }

    public void alterar(Paciente pacientes) throws SQLException {
      PacienteDAO pacienteDAO = new PacienteDAO();
      PacienteDAO.alterar(pacientes);
    }
    
}
