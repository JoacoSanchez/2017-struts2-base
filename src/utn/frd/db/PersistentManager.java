package utn.frd.db;

import java.util.ArrayList;
import java.util.List;
import utn.frd.bean.Persona;

public class PersistentManager {
	private static List<Persona> data = new ArrayList<Persona>();
	
	public static List<Persona> getInstance(){
		return data;
	}
	public static void setData(List<Persona> data) {
		PersistentManager.data = data;
	} 
}
