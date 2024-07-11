
package bean;

import java.time.LocalDate;

public class Tarjeta {
    
    private String tipo, nombre, apellido, fecha;
    private short codigo;
    private long numero;

    public Tarjeta() {
    }

    public Tarjeta(String tipo, String nombre, String apellido, short codigo, long numero, String fecha) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.numero = numero;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", numero=" + numero + ", fecha=" + fecha + '}';
    }
    
    
    
}
