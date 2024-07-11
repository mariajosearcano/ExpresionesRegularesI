package logica;

import java.util.ArrayList;
import java.util.Iterator;

import bean.ArrayArrays;

public class LArray {
	
	public ArrayArrays principal;
	
	public LArray()
	{
		principal= new ArrayArrays();
	}
	
	public void ingreso(String cadena)
	{
		ArrayList secundario= new ArrayList<>();
		String[] vCadena =cadena.split(" ");
		int i=0;
		while(i<vCadena.length)
		{
			secundario.add(Integer.parseInt(vCadena[i]));
			i++;
		}
		principal.getaPrincipal().add(secundario);
		
	}
	
	public boolean validar(String cadena, int n, int max) {
		
		String regrex= "(\s*[0-"+max+"]){"+n+"}";
	
		return cadena.matches(regrex);
	}
	
	public int numeroNodos()
	{
		if(principal.getaPrincipal().size()==0)
		{
		return 3;
		}
		else
		{
			return ((principal.getaPrincipal().size()+1)*2)+1;
		}
	}

	public int mayor()
	{
		int may= 0,i=0;
		
		while(i<principal.getaPrincipal().size())
		{
			Iterator<Integer> iterator= principal.getaPrincipal().get(i).iterator();
			i++;
			while(iterator.hasNext())
			{
				int n= iterator.next();
				if(n>may)
					may=n;
				
			}
		}
		
		return may;
	}
	
}
