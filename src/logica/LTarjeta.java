
package logica;

import bean.Docente;
import bean.Tarjeta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class LTarjeta {
    
    private ArrayList<Tarjeta> arrayTarjeta;

    public LTarjeta() {
        arrayTarjeta = new ArrayList<>();
    }

    public LTarjeta(ArrayList<Tarjeta> arrayTarjeta) {
        this.arrayTarjeta = arrayTarjeta;
    }

    public ArrayList<Tarjeta> getArrayTarjeta() {
        return arrayTarjeta;
    }

    public void setArrayTarjeta(ArrayList<Tarjeta> arrayTarjeta) {
        this.arrayTarjeta = arrayTarjeta;
    }
    
    public boolean es(String cadena, String regex){
        return cadena.matches(regex);
    }
    
    /*public LocalDate aLocalDate(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        
        return LocalDate.parse(fecha, formatter);
    }*/
    
    public ArrayList<Tarjeta> tipoToArray(String regex){
        ArrayList<Tarjeta> arrayTipo = new ArrayList<>();
        
        for (Tarjeta tarjeta : arrayTarjeta){
            if(es(tarjeta.getTipo(), regex)){
                arrayTipo.add(tarjeta);
            }
        }
        
        return arrayTipo;
    }
    
    public String obtenerAnio(String fecha){
        String cadena = "";
        Pattern p = Pattern.compile("/(\\d+)$");
        Matcher m = p.matcher(fecha);
        
        if (m.find()){
            cadena = m.group(1);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        return cadena;
    }
    
    
}
