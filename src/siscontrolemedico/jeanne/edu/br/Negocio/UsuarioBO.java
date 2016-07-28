/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import siscontrolemedico.jeanne.br.eu.Entidade.Paciente;
import siscontrolemedico.jeanne.br.eu.Entidade.Usuario;
import siscontrolemedico.jeanne.edu.br.Excessao.CpfExisteException;
import siscontrolemedico.jeanne.edu.br.Excessao.LoginExisteException;
import siscontrolemedico.jeanne.edu.br.Excessao.UsuarioInexistenteException;
import siscontrolemedico.jeanne.edu.br.Persistencia.UsuarioDAO;
import siscontrolemedico.jeanne.edu.br.Excessao.PesquisaNaoEncontradaException;
import siscontrolemedico.jeanne.edu.br.Persistencia.PacienteDAO;

/**
 
 * @author Jeanne
 */
public class UsuarioBO {

     public void inserir(Usuario usuarios) throws SQLException{
              
        UsuarioDAO usuariosDAO = new UsuarioDAO();
        this.VerificarCPF(usuarios);
        this.VerificarRG(usuarios);
        this.verificaLogin(usuarios);
        usuariosDAO.inserir(usuarios);
    }

   public Usuario buscarLogin(Usuario usuario) throws SQLException {
        Usuario usuarioExistente = null;
        UsuarioDAO usuariosDAO = new UsuarioDAO();
     
        usuarioExistente = usuariosDAO.buscarLogin(usuario);
        
        if(usuarioExistente != null){
            return usuarioExistente;
        }else{
            throw new UsuarioInexistenteException("Usuario inexistente");
        }
    }

    public Usuario pesquisar(Usuario usuarioPesquisado) throws SQLException {
        Usuario usuarioAtual = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioAtual = usuarioDAO.pesquisarLogin(usuarioPesquisado.getNome());
        if(usuarioAtual != null){
            return usuarioAtual;
        }else{
            throw new PesquisaNaoEncontradaException();
        }
    }

    public void excluir(String nome) throws SQLException {
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      usuarioDAO.excluir(nome);
    }    
     public String criptografarSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = null;
        messageDigest = algoritmo.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();

        return senhaCriptografada;
    }
    private void VerificarCPF(Usuario usuarios) throws SQLException {
        Usuario cpfUsuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        cpfUsuarioExistente = usuarioDAO.VerificarCPF(usuarios.getCpf());
        if (cpfUsuarioExistente != null) {
            throw new CpfExisteException();
        }
    }

    private void VerificarRG(Usuario usuarios) throws SQLException {
        Usuario RGUsuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        RGUsuarioExistente = usuarioDAO.VerificarRG(usuarios.getRg());
        if (RGUsuarioExistente != null) {
            throw new CpfExisteException();
        }
    }

    private void verificaLogin(Usuario usuarios) throws SQLException {
       Usuario RGUsuarioExistente = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        RGUsuarioExistente = usuarioDAO.VerificarLogin(usuarios.getLogin());
        if (RGUsuarioExistente != null) {
            throw new LoginExisteException();
        }
    }

    public List<Usuario> pesquisarMedico(Usuario usuarioPesquisado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterar(Usuario usuario) throws SQLException {
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      usuarioDAO.alterar(usuario);
    }
}

