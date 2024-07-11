package bean;

import java.util.ArrayList;

public class Codigo {

	private ArrayList<String[]> array;

	public ArrayList getArray() {
		return array;
	}

	public void setArray(ArrayList array) {
		this.array = array;
	}

	public Codigo(ArrayList array) {
		super();
		this.array = array;
	}
	
	public Codigo()
	{
		array = new ArrayList<String[]>();
	}
	
}
