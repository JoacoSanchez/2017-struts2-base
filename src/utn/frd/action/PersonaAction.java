package utn.frd.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import utn.frd.bean.Persona;
import utn.frd.db.PersistentManager;

public class PersonaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String gender;
	private List<Persona> personas;
	private long id;
	
//-------------------INICIALIZADOR---------------

	public String iniciar(){
		personas = PersistentManager.getInstance(); 
		
		name = "lalala";
		gender = "Masculino";
		
		return SUCCESS;
	}

//-------------------GETTERS Y SETTERS--------------------
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
//--------------------------------------------------
	
	public String save(){
		personas = PersistentManager.getInstance(); 
		int edad = 0;
		Persona p;
		//tuve que agregar estas variables locales auxiliares para asegurarme que no se deje un espacio vacio
		int aux1;
		int aux2;
		int aux3;
		try{
			edad = Integer.parseInt(age);
			aux1 = name.length();
			aux2 = gender.length();
			aux3 = 1 / aux2;
			aux3 = 1 / aux1;
		}catch(Exception e){
			addActionError("Ocurrió un error");
			return ERROR;
		}
		p = new Persona(personas.size(), name, edad, gender);
		personas.add(p);
		setName("");
		setAge("");
		setGender("");
		return SUCCESS;
	}
	
	 public String eliminar(){
		personas = PersistentManager.getInstance();
		//java8
		//personas.removeIf(p-> p.getId()==id);
	
		//Solucion B
		personas.remove((int)id);
		int x = 0;
		for(Persona p : personas){
			p.setId(x++);
		}
		//fin solucion B

		/* solucion A
		int x = 0;
		List<Persona> aux = new ArrayList<Persona>();
		for(Persona p : personas){
			if(p.getId()!=id){
				p.setId(x++);
				aux.add(p);
			}
		}
		personas.clear();
		
		personas.addAll(aux);
		
		//PersistenManager.setData(aux);
		*/
		return SUCCESS;
	}
	 
	 public String modificar(){
		 personas = PersistentManager.getInstance();
		 
		 Persona p = personas.get((int) id);
		 name = p.getName();
		 age = "" + p.getAge();
		 gender = p.getGender();
		 personas.remove(p);
		 return SUCCESS;
	 }
	 public String guardarModificacion(){
		 
		 /*
		 personas = PersistentManager.getInstance();
		 Persona p = personas.get((int) id);
		 p.setName(name);
		 p.setAge(Integer.parseInt(age));
		 p.setGender(gender);
		 return SUCCESS;
		 */
		 
		 personas = PersistentManager.getInstance(); 
			int edad = 0;
			Persona p;
			int aux1;
			int aux3;
			try{
				edad = Integer.parseInt(age);
				aux1 = name.length();
				aux3 = 1 / aux1;
			}catch(Exception e){
				addActionError("Ocurrió un error");
				return ERROR;
			}
			p = new Persona(id, name, edad, gender);
			personas.add(p);
			// solucion temporal -> (mi idea original era agregar a la persona en "personas" con el id que trajera como 
			//                                 parametro, y despues ordenar la lista en base del id)
			// esta solucion me agrega la persona modificada a la base de "personas"
			int x = 0;
			for(Persona k : personas){
				k.setId(x++);
			}
			setName("");
			setAge("");
			setGender("");
			return SUCCESS;
		}
}