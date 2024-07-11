
package vista;

import bean.Docente;
import bean.Tarjeta;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logica.LTarjeta;

public class VTarjeta {
    
    private LTarjeta ltarjeta;

    public VTarjeta() {
        ltarjeta = new LTarjeta();
    }

    public VTarjeta(LTarjeta ltarjeta) {
        this.ltarjeta = ltarjeta;
    }

    public LTarjeta getLtarjeta() {
        return ltarjeta;
    }

    public void setLtarjeta(LTarjeta ltarjeta) {
        this.ltarjeta = ltarjeta;
    }
    
    public void ingreso(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1));
        
        /*JComboBox<String> comboBoxTipo = new JComboBox<>();
        comboBoxTipo.addItem("Seleccione un tipo de tarjeta");
        comboBoxTipo.addItem("MasterCard");
        comboBoxTipo.addItem("Visa");
        panel.add(comboBoxTipo);*/
        
        JLabel labelTipo = new JLabel("Ingrese el tipo de tarjeta (MasterCard o Visa): ");
        panel.add(labelTipo);
        JTextField textFieldTipo = new JTextField();
        panel.add(textFieldTipo);
        
        JLabel labelNombre = new JLabel("Ingrese su nombre en MAYUSCULAS: ");
        panel.add(labelNombre);
        JTextField textFieldNombre = new JTextField();
        panel.add(textFieldNombre);
        
        JLabel labelApellido = new JLabel("Ingrese su apellido en MAYUSCULAS: ");
        panel.add(labelApellido);
        JTextField textFieldApellido = new JTextField();
        panel.add(textFieldApellido);
        
        JLabel labelCodigo = new JLabel("Ingrese el codigo de verificacion: ");
        panel.add(labelCodigo);
        JTextField textFieldCodigo = new JTextField();
        panel.add(textFieldCodigo);

        JLabel labelNumero = new JLabel("Ingrese el numero de la tarjeta: ");
        panel.add(labelNumero);
        JTextField textFieldNumero = new JTextField();
        panel.add(textFieldNumero);
        
        JLabel labelFecha = new JLabel("Ingrese la fecha (mm/yy): ");
        panel.add(labelFecha);
        JTextField textFieldFecha = new JTextField();
        panel.add(textFieldFecha);

        int opcion = JOptionPane.showConfirmDialog(null, panel, "Ingresa los datos de la tarjeta: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        String tipo = textFieldTipo.getText(), numero = textFieldNumero.getText(), fecha = textFieldFecha.getText(), nombre = textFieldNombre.getText(), apellido = textFieldApellido.getText(), codigo = textFieldCodigo.getText();
        
        if (opcion == JOptionPane.OK_OPTION) {
            tipo = validar(tipo, "^MasterCard$|^Visa$", "Ingresa un tipo de tarjeta valido (MasterCard o Visa): ");
            nombre = validar(nombre, "^[A-Z]+$", "Ingrese un nombre valido en MAYUSCULAS: ");
            apellido = validar(apellido, "^[A-Z]+$", "Ingrese un apellido valido en MAYUSCULAS: ");
            codigo = validar(codigo, "^\\d{3}$", "Ingrese un codigo valido (3 digitos): ");
            numero = validar(numero, "^\\d{16}$", "Ingrese un numero de tarjeta valido (16 digitos): ");
            fecha = validar(fecha, "^(0[1-9]|1[0-2])/\\d{2}$", "Ingrese una fecha valida (mm/yy): ");
            
            Tarjeta tarjeta = new Tarjeta(tipo, nombre, apellido, Short.parseShort(codigo), Long.parseLong(numero), fecha);
            
            ltarjeta.getArrayTarjeta().add(tarjeta);
            JOptionPane.showMessageDialog(null, "Se agrego la tarjeta correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        mostrar(concatenar(ltarjeta.getArrayTarjeta()), "Listado tarjetas");
        JOptionPane.showMessageDialog(null, "A continuacion se mostraran las listas de las tarjetas MasterCard y Visa", "Advertencia", JOptionPane.WARNING_MESSAGE);
        mostrar(concatenar(ltarjeta.tipoToArray("^MasterCard$")), "Tarjetas MasterCard");
        mostrar(concatenar(ltarjeta.tipoToArray("^Visa$")), "Tarjetas Visa");
    }
    
    
    public String validar(String cadena, String regex, String mensaje){
        while(!ltarjeta.es(cadena, regex)){
            cadena = JOptionPane.showInputDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return cadena;
    }
    
    public String concatenar(ArrayList<Tarjeta> array){
        String cadena = "";
        
        for (Tarjeta tarjeta : array){
            cadena += tarjeta.toString() + "\n";
        }
        
        return cadena;
    }
    
    public void mostrar(String cadena, String titulo){
        JOptionPane.showMessageDialog(null, cadena, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String ingresoAnio(){
        String anio = JOptionPane.showInputDialog(null, "Ingrese año para filtrar tarjetas de la lista: ", "Pregunta", JOptionPane.QUESTION_MESSAGE);
        
        while(!ltarjeta.es(anio, "^[0-9]{2}$"))
            anio = JOptionPane.showInputDialog(null, "Ingrese un año valido (de dos cifras): ", "Error", JOptionPane.ERROR_MESSAGE);
        
        return anio;
    }
    
    public String concatenar(ArrayList<Tarjeta> array, String anio){
        String cadena = "";
        
        for (Tarjeta tarjeta : array){
            if(ltarjeta.es(ltarjeta.obtenerAnio(tarjeta.getFecha()), anio))
                cadena += tarjeta.toString() + "\n";
        }
        
        return cadena;
    }
    
    
    
}
