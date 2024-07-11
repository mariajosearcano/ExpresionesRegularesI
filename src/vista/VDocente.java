
package vista;

import bean.Docente;
import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.LDocente;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VDocente {
    
    private LDocente ldocente;

    public VDocente() {
        ldocente = new LDocente();
    }

    public VDocente(LDocente ldocente) {
        this.ldocente = ldocente;
    }

    public LDocente getLdocente() {
        return ldocente;
    }

    public void setLdocente(LDocente ldocente) {
        this.ldocente = ldocente;
    }
    
    public String concatenar(ArrayList<Docente> array){
        String cadena = "";
        
        for (Docente docente : array){
            cadena += docente.toString() + "\n";
        }
        
        return cadena;
    }
    
    public void mostrar(String cadena){
        JOptionPane.showMessageDialog(null, cadena, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void ingreso(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel labelCedula = new JLabel("Ingrese la cedula: ");
        panel.add(labelCedula);
        JTextField textFieldCedula = new JTextField();
        panel.add(textFieldCedula);

        JComboBox<String> comboBoxTipo = new JComboBox<>();
        comboBoxTipo.addItem("Seleccione un tipo de docente");
        comboBoxTipo.addItem("Docente de Planta");
        comboBoxTipo.addItem("Docente Ocasional");
        comboBoxTipo.addItem("Docente de Catedra");
        panel.add(comboBoxTipo);
        
        JLabel labelFecha = new JLabel("Ingrese la fecha (dd-mm-yyyy): ");
        panel.add(labelFecha);
        JTextField textFieldFecha = new JTextField();
        panel.add(textFieldFecha);
        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Ingresa los datos del docente: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        String cedula = textFieldCedula.getText(), tipo = comboBoxTipo.getSelectedItem().toString(), fecha = textFieldFecha.getText();
        
        if (opcion == JOptionPane.OK_OPTION) {
            //int[] contador = new int[1];
            cedula = validar(cedula, "^[0-9]{10}$", "Ingresa una cedula valida: ");
            //tipo = validar(tipo, "^(Docente de (Planta|Catedra)|Docente Ocasional)$", "Ingresa un tipo valido (Docente de Planta, Docente Ocasional o Docente de Catedra): ");
            tipo = validar(tipo);
            fecha = validar(fecha, "^([0-2][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$", "Ingrese una fecha valida (dd-mm-yyyy): ");
            
            Docente docente = new Docente(Long.parseLong(cedula), tipo, fecha);
            
            ldocente.getArrayDocente().add(docente);
            JOptionPane.showMessageDialog(null, "Se agrego el docente correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        mostrar(concatenar(ldocente.getArrayDocente()));
    }
    
    public String validar(String cadena, String regex, String mensaje){
        int contador = 0;
        
        while(!ldocente.es(cadena, regex)){
            cadena = JOptionPane.showInputDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            contador++;
        }
        
        if(ldocente.es(cadena, "^[0-9]{10}$"))
            JOptionPane.showMessageDialog(null, "Agragaste bien la cedula, te equivocaste: " + contador + " veces para poder ingresarla bien", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        
        return cadena;
    }
    
    public String validar(String tipo){
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(5, 1));
        
        JComboBox<String> comboBoxTipo = new JComboBox<>();
        comboBoxTipo.addItem("Error, Seleccione un tipo de docente VALIDO: ");
        comboBoxTipo.addItem("Docente de Planta");
        comboBoxTipo.addItem("Docente Ocasional");
        comboBoxTipo.addItem("Docente de Catedra");
        panel.add(comboBoxTipo);
        
        while(!ldocente.es(tipo, "^(Docente de (Planta|Catedra)|Docente Ocasional)$")){
            int opcion = JOptionPane.showConfirmDialog(null, panel, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(opcion == JOptionPane.OK_OPTION){
                tipo = comboBoxTipo.getSelectedItem().toString();
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
                break;
            }
        }
        
        return tipo;
    }
    
    public String concatenar(){
        String cadena = ldocente.porcentaje(ldocente.numeroDocentes("Docente de Planta")) + "% docentes de planta" + "\n" + ldocente.porcentaje(ldocente.numeroDocentes("Docente Ocasional")) + "% docentes ocasionales" + "\n" + ldocente.porcentaje(ldocente.numeroDocentes("Docente de Catedra")) + "% docentes de catedra";
    
        return cadena;
    }
    
    
    
    
}

