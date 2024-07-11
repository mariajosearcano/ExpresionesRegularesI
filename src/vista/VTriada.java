
package vista;

import bean.Triada;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.LTriada;

public class VTriada {

    private LTriada ltriada;
    
    public VTriada() {
        ltriada = new LTriada();
    }

    public VTriada(LTriada ltriada) {
        this.ltriada = ltriada;
    }
    
    public LTriada getLtriada() {
        return ltriada;
    }

    public void setLtriada(LTriada ltriada) {
        this.ltriada = ltriada;
    }
    
    public void crear(){
        int numero = ltriada.getArrayTriada().size() + Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de triada(s) que deseas agregar: ", "Ingreso", JOptionPane.QUESTION_MESSAGE));
        
        while(!ltriada.esPrimo(numero)){
            numero = ltriada.getArrayTriada().size() + Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa un numero que al ser sumado con la cantidad de nodos existentes (" + ltriada.getArrayTriada().size() + ") de un numero primo: ", "Error", JOptionPane.ERROR_MESSAGE));
        }
        
        ingreso(numero);
    }
    
    public void ingreso(int numero){
        JTextField primero = new JTextField(), segundo = new JTextField(), tercero = new JTextField();
        
        Object[] mensaje = {
            "Primer numero: ", primero,
            "Segundo numero: ", segundo,
            "Tercer numero: ", tercero,
        };
        
        for(int i=0; i<numero; i++){
            int opcion = JOptionPane.showConfirmDialog(null, /*"Ingresa los numeros a agregar a la triada: " + "\n" +*/ mensaje, "Ingresa los numeros a agregar a la triada #" + (i+1) + ": ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            String cadena1 = primero.getText(), cadena2 = segundo.getText(), cadena3 = tercero.getText();
            
            if(opcion == JOptionPane.OK_OPTION){
                cadena1 = cifras(cadena1);
                cadena2 = cifras(cadena2);
                cadena3 = cifras(cadena3);
                
                cadena2 = numeroMayor(cadena1, cadena2);
                cadena3 = numeroMayor(cadena2, cadena3);
                
                Triada triada = new Triada(Integer.parseInt(cadena1), Integer.parseInt(cadena2), Integer.parseInt(cadena3));
                
                ltriada.getArrayTriada().add(triada);
                JOptionPane.showMessageDialog(null, "Se agrego la triada #" + ltriada.getArrayTriada().size() +" correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
                break;
            }
        }
        
        mostrar(concatenarArray());
        JOptionPane.showMessageDialog(null, "A continuacion se mostraran los promedios concatenados", "Advertencia", JOptionPane.WARNING_MESSAGE);
        mostrar(concatenarPromedios());
    }
    
    public String cifras(String cadena){
        while(!ltriada.esCifras(cadena)){
            cadena = JOptionPane.showInputDialog(null, "Por favor ingresa un numero de -" + (ltriada.getArrayTriada().size()+1) + "- cifra(s) [No como " + cadena + " que tiene " + cadena.length() + " cifra(s)]; o fijate que no inicie con cero: ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return cadena;
    }
    
    public String numeroMayor(String cadena1, String cadena2){
        while(!ltriada.esNumeroMayor(Integer.parseInt(cadena1), Integer.parseInt(cadena2))){
            cadena2 = JOptionPane.showInputDialog(null, "Ingresa un numero mayor al anterior (# > " + cadena1 + "): ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return cadena2;
    }
    
    public void mostrar(String cadena){
        JOptionPane.showMessageDialog(null, cadena, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String concatenarPromedios(){
        int i = 0;
        String cadena = "";
        
        for(int j=(ltriada.getArrayTriada().size()-1); j>=i; j--){
            if(i != j){
                int promedio1 = ltriada.promedio(ltriada.getArrayTriada().get(i));
                int promedio2 = ltriada.promedio(ltriada.getArrayTriada().get(j));
                cadena += ", " + promedio1 + ", " + promedio2;
            } else {
                int promedio = (ltriada.getArrayTriada().get(i).getPrimero()+ltriada.getArrayTriada().get(i).getSegundo()+ltriada.getArrayTriada().get(i).getTercero()) / 3;
                cadena += ", " + promedio;
            }
            
            if(ltriada.getArrayTriada().size() == 2)
                break;
            
            i++;
        }
        
        return cadena.substring(2, cadena.length());
    }
    
    /*public String concatenarValores(){
        String cadena = "";    
        
        for (Triada triada : ltriada.getArrayTriada()){
            cadena += "| " + triada.getPrimero() + " |" + "| " + triada.getSegundo() + " |" + "| " + triada.getTercero() + " |" + "\n";
        }
        
        return cadena;
    }*/
    
    public String concatenarArray(){
        String cadena = "";    
        
        for (Triada triada : ltriada.getArrayTriada()){
            cadena += triada.toString() + "\n";
        }
        
        return cadena;
    }
    
}
