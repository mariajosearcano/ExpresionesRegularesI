package vista;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.LCodigo;

public class VCodigo {
	
	private LCodigo lcod;
	
	public VCodigo(LCodigo lcod) {
		super();
		this.lcod = lcod;
	}
	
	public VCodigo()
	{
		lcod= new LCodigo();
	}

	public void ingreso()
	{
		JTextField registro1 = new JTextField();
		JTextField registro2 = new JTextField();
		JTextField registro3 = new JTextField();
		Object[] message = {
			    "B123 123-123456:", registro1,
			    "1234ABCDRE45:", registro2,
			    "E-ISSN 1234-1234:", registro3
			};
		int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los datos para cada nodo\n (Ejemplo)", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			String[] vCadena= new String[3];
			vCadena[0]=registro1.getText();
			vCadena[1]=registro2.getText();
			vCadena[2]=registro3.getText();
			lcod.ingreso(vCadena);
		}
	}
	
	public void repetidos()
	{
		lcod.repetidos();
		int i=0;
		String s="";
		while(i<lcod.getRepetid().size())
		{
			
			s+= lcod.getRepetid().get(i)+"\n";
			i++;
		}
		
		JOptionPane.showMessageDialog(null,"Elementos con numeros repetidos:\n"+ s);
	}
}
