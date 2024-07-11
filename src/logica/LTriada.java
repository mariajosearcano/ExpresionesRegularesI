//1mer punto
package logica;

import bean.Triada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vista.VTriada;

public class LTriada {
    
    private ArrayList<Triada> arrayTriada;

    public LTriada() {
        arrayTriada = new ArrayList<>();
    }

    public LTriada(ArrayList<Triada> arrayTriada) {
        this.arrayTriada = arrayTriada;
    }

    public ArrayList<Triada> getArrayTriada() {
        return arrayTriada;
    }

    public void setArrayTriada(ArrayList<Triada> arrayTriada) {
        this.arrayTriada = arrayTriada;
    }
    
    public boolean esPrimo(int numero){
        return (numero==2 || numero==3 || numero==5 || numero==7) || (numero!=1 && numero%2!=0 && numero%3!=0 && numero%5!=0 && numero%7!=0);
    }
           
    public boolean esCifras(String cadena){
        boolean bandera = false;
        
        if(arrayTriada.size() == 0){
            bandera = cadena.matches("^0+$|^[1-9]{1}$");
        } else {
            bandera = cadena.matches("^[1-9]\\d{" + arrayTriada.size() + "}$");
        }
        
        return bandera;
    }
    
    public boolean esNumeroMayor(int numero1, int numero2){
        return numero1 < numero2;
    }
    
    public int promedio(Triada triada) {
        return (triada.getPrimero() + triada.getSegundo() + triada.getTercero()) / 3;
    }

    
    
}
