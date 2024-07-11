
package logica;

import bean.Docente;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class LDocente {
    
    private ArrayList<Docente> arrayDocente;

    public LDocente() {
        arrayDocente = new ArrayList<>();
    }

    public LDocente(ArrayList<Docente> arrayDocente) {
        this.arrayDocente = arrayDocente;
    }

    public ArrayList<Docente> getArrayDocente() {
        return arrayDocente;
    }

    public void setArrayDocente(ArrayList<Docente> arrayDocente) {
        this.arrayDocente = arrayDocente;
    }
    
    /*public boolean esCedula(String scedula){
        return scedula.matches("^[0-9]{10}$");
    }*/
    
    /*public boolean esTipo(String cadena){
        return cadena.matches("^(Docente de (Planta|Catedra)|Docente Ocasional)$");
    }*/
    
    /*public boolean esFecha(String sfecha){
        return sfecha.matches("^(([0-2][0-9]|3[01])-(0[1-9]|1[0-2])\\1\\d{4})$");
    }*/
    
    public boolean es(String cadena, String regex){
        return cadena.matches(regex);
    }
    
    public ArrayList<Docente> docentesCatedraSeptiembreToArray(){
        ArrayList<Docente> arrayCatedraSeptiembre = new ArrayList<>();
        
        for (Docente docente : arrayDocente){
            if(es(docente.getTipo(), "Docente de Catedra") && es(docente.getFecha(), "^([0-2][0-9]|3[01])-09-\\d{4}$")){
                arrayCatedraSeptiembre.add(docente);
            }
        }
        
        return arrayCatedraSeptiembre;
    }
    
    /*public LocalDate aLocalDate(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        return LocalDate.parse(fecha, formatter);
    }
    
    public String aString(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return fecha.format(formatter);
    }*/
    
    public double numeroDocentes(String regex){
        double contador = 0;
        
        for (Docente docente : arrayDocente){
            if(es(docente.getTipo(), regex)){
                contador++;
            }
        }
        
        return contador;
    }

    public double porcentaje(double numero) {
        //(valor/valorbase)*100
        return (numero / (double)arrayDocente.size()) * 100;
    }
    
    /*public void equivocacion(int[] contador){
        contador[0]++;
    }*/
    
}
