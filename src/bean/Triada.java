
package bean;

public class Triada {
    
    private int primero, segundo, tercero;

    public Triada() {
    }
    
    public Triada(int primero, int segundo, int tercero) {
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }

    public int getPrimero() {
        return primero;
    }

    public void setPrimero(int primero) {
        this.primero = primero;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public int getTercero() {
        return tercero;
    }

    public void setTercero(int tercero) {
        this.tercero = tercero;
    }

    @Override
    public String toString() {
        return "Triada{" + "primero=" + primero + ", segundo=" + segundo + ", tercero=" + tercero + '}';
    }
    
    
    
}
