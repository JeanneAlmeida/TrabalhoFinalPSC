/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siscontrolemedico.jeanne.edu.br.Negocio;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Jeanne
 */
public class ConverterData {
     public static Date FormatarData(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataSql = new Date(format.parse(data).getTime());
        return dataSql;
    }

    public static Time FormatarHora(String horario) throws ParseException {
      DateFormat format = new SimpleDateFormat("HH:mm");
        Time horaSql = new Time(format.parse(horario).getTime());
        return horaSql;
    }
    public static String DataParaString(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = format.format(data);
        return dataString;
    }
}
