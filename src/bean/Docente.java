
package bean;

import java.time.LocalDate;
import logica.LDocente;

public class Docente {
    
    private long cedula;
    private String tipo, fecha;

    public Docente() {
    }

    public Docente(long cedula, String tipo, String fecha) {
        this.cedula = cedula;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        LDocente ldocente = new LDocente();
        
        return "Docente{" + "cedula=" + cedula + ", tipo=" + tipo + ", fecha=" + fecha + '}';
    }
    
    
    
}
