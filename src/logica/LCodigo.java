package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import bean.Codigo;

public class LCodigo {

	private Codigo codigo;
	private ArrayList<String> repetid;

	public LCodigo()
	{
		codigo= new Codigo();
		repetid= new ArrayList<String>();
	}
	
	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	public ArrayList<String> getRepetid() {
		return repetid;
	}

	public void setRepetid(ArrayList<String> repetid) {
		this.repetid = repetid;
	}

	public void ingreso(String[] vCadena) {
		
		String regrex1="[A-Z](\\d{3}) (\\d{3})-(\\d{6})?";
		String regrex2="^1\\d{3}[A-Z]{6}[3-9]{2}?";
		String regrex3="^E-ISSN \\d{4}-\\d{4}?";
		boolean al=false;
		Pattern p= Pattern.compile(regrex1);
		Matcher m= p.matcher(vCadena[0]);
		if(m.matches()) {
			p= Pattern.compile(regrex2);
			m= p.matcher(vCadena[1]);
			if(m.matches()) {
				p= Pattern.compile(regrex3);
				m= p.matcher(vCadena[2]);
				if(m.matches()) {
					al=true;
					codigo.getArray().add(vCadena);
					JOptionPane.showMessageDialog(null, "ingresado exitosamente");
				}
			}
		}
		if(al==false)
		{
			JOptionPane.showMessageDialog(null, "Hubo un error, no se pudieron ingresar los datos");
		}
		
	}
	
	public void repetidos()
	{
		String regex = ".*?(\\d)\\1.*?";
		Pattern p= Pattern.compile(regex);
		Matcher m;
		
		Iterator<String[]> iterador= codigo.getArray().iterator();
		while(iterador.hasNext())
		{
			String[] vect= iterador.next();
			int i=0;
			while(i<vect.length)
			{
				m= p.matcher(vect[i]);
				if(m.matches())
				{
					repetid.add(vect[i]);
				
				}
				i++;
			}
		}
		
	}
	
}
