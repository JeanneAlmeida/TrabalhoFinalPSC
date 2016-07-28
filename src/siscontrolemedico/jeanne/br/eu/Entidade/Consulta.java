
package siscontrolemedico.jeanne.br.eu.Entidade;

import java.sql.Time;
import java.util.Date;

public class Consulta {
    private  int id;
    private Paciente paciente = new Paciente();
    private Date data;
    private Time horario;
    private Usuario usuario = new Usuario();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    
   
}
