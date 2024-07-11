
package vista;

import java.util.Random;

import javax.swing.JOptionPane;

import logica.LArray;

public class Menu {
    
    public void menuPrincipal(){
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Triada
                                                                        2. Arrays
                                                                        3. Docente
                                                                        4. Codigo
                                                                        5. Tarjeta
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    menuTriada();
                    break;
                case 2: 
                    menuArrays();
                    break;
                case 3:
                    menuDocente();
                    break;
                case 4:
                    menuCodigo();
                    break;
                case 5:
                    menuTarjeta();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saldra del programa, hasta la proxima", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuTriada(){
        VTriada vtriada = new VTriada();
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Crear o agregar triada(s)
                                                                        2. Mostrar Promedio(s)
                                                                        3. Mostrar triadas
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Triada", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    vtriada.crear();
                    break;
                case 2:
                    vtriada.mostrar(vtriada.concatenarPromedios());
                    break;
                case 3:
                    vtriada.mostrar(vtriada.concatenarArray());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al menu principal", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuDocente(){
        VDocente vdocente = new VDocente();
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Ingresar datos docente(s)
                                                                        2. Porcentaje de tipos de docentes
                                                                        3. Docentes de catedra mes de septiembre
                                                                        4. Mostrar docentes
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Docente", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    vdocente.ingreso();
                    break;
                case 2:
                    vdocente.mostrar(vdocente.concatenar());
                    break;
                case 3:
                    vdocente.mostrar(vdocente.concatenar(vdocente.getLdocente().docentesCatedraSeptiembreToArray()));
                    break;
                case 4:
                    vdocente.mostrar(vdocente.concatenar(vdocente.getLdocente().getArrayDocente()));
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al menu principal", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuArrays(){
        LArray lArray = new LArray();
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Crear o agregar array
                                                                        2. Hallar mayor(s)
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Arrays", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1:
                	Random rand= new Random();
                	int max=rand.nextInt(6)+4; 
                	String cadena= JOptionPane.showInputDialog(null, "ingrese "+lArray.numeroNodos()+" numeros separados por espacio y hasta "+ max);
                    if(lArray.validar(cadena, lArray.numeroNodos(), max))
                    	lArray.ingreso(cadena);
                    else
                    	JOptionPane.showMessageDialog(null, "Ingreso cancelado, hubo un error");
                	
                    break;
                case 2: JOptionPane.showMessageDialog(null, "El numero mayor es: "+ lArray.mayor());
                    
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al menu principal", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuCodigo(){
        VCodigo cod= new VCodigo();
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Insertar Codigos
                                                                        2. Hallar repetidos
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Codigo", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1:	cod.ingreso();
                	
                    break;
                case 2: cod.repetidos();
                    
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al menu principal", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuTarjeta(){
        VTarjeta vtarjeta = new VTarjeta();
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Ingresar datos tarjeta(s)
                                                                        2. Listas segun tipo de tarjeta
                                                                        3. Listas tarjetas en determinado año
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Tarjeta", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    vtarjeta.ingreso();
                    break;
                case 2:
                    menuTarjetaTipo(vtarjeta);
                    break;
                case 3:
                    menuTarjetaAnio(vtarjeta);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al Principal", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuTarjetaTipo(VTarjeta vtarjeta){
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Listado tarjetas MasterCard
                                                                        2. Listado tarjetas Visa
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Tarjeta Tipo", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    vtarjeta.mostrar(vtarjeta.concatenar(vtarjeta.getLtarjeta().tipoToArray("^MasterCard$")), "Listado tarjetas MasterCard");
                    break;
                case 2:
                    vtarjeta.mostrar(vtarjeta.concatenar(vtarjeta.getLtarjeta().tipoToArray("^Visa$")), "Listado tarjetas Visa");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al Menu Tarjeta", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
    public void menuTarjetaAnio(VTarjeta vtarjeta){
        int opcion = 0;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Listado tarjetas con año determinado en general
                                                                        2. Listado tarjetas con año determinado de tipo MasterCard
                                                                        3. Listado tarjetas con año determinado de tipo Visa
                                                                        0. Salir
                                                                        
                                                                        """, "Menu Tarjeta Año", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                    vtarjeta.mostrar(vtarjeta.concatenar(vtarjeta.getLtarjeta().getArrayTarjeta(), vtarjeta.ingresoAnio()), "Listado de todas las tarjetas segun el año especificado");
                    break;
                case 2:
                    vtarjeta.mostrar(vtarjeta.concatenar(vtarjeta.getLtarjeta().tipoToArray("^MasterCard$"), vtarjeta.ingresoAnio()), "Listado tarjetas MasterCard segun el año especificado");
                    break;
                case 3:
                    vtarjeta.mostrar(vtarjeta.concatenar(vtarjeta.getLtarjeta().tipoToArray("^Visa$"), vtarjeta.ingresoAnio()), "Listado tarjetas Visa segun el año especificado");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Volvera al Menu Tarjeta", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
}
