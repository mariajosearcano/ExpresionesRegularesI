package bean;

import java.util.ArrayList;

public class ArrayArrays {
	
	private ArrayList<ArrayList> aPrincipal;

	public ArrayArrays(ArrayList<ArrayList> aPrincipal) {
		super();
		this.aPrincipal = aPrincipal;
	}
	
	public ArrayArrays()
	{
		aPrincipal = new ArrayList<ArrayList>();
	}

	public ArrayList<ArrayList> getaPrincipal() {
		return aPrincipal;
	}

	public void setaPrincipal(ArrayList<ArrayList> aPrincipal) {
		this.aPrincipal = aPrincipal;
	}

}
