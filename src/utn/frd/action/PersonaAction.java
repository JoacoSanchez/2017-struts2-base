package utn.frd.action;

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
	
//-------------------INICIALIZADOR---------------
	
	public String iniciar(){
		personas = PersistentManager.getInstance(); 
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
		/*
		if (name=="" || gender==""){
			addActionError("Hubieron casillas sin rellenar");
			return ERROR;
		}
		*/
		p = new Persona(personas.size(), name, edad, gender);
		personas.add(p);
		setName("");
		setAge("");
		setGender("");
		return SUCCESS;
	}
}
