/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Excessao;

/**
 *
 * @author Jeanne
 */
public class PesquisaNaoEncontradaException extends SiscontroleMedicoException {
    public PesquisaNaoEncontradaException(){
        super("A consulta realizada não encontrou nenhum resultado!");
    }
}
