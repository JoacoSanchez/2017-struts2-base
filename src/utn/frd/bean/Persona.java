package utn.frd.bean;

public class Persona {
	private long id;
	private String name;
	private int age;
	private String gender;

	public Persona(long id, String name, int age, String gender) {
		//this.id = ident;
		//this.name = nombre;
		//this.age = edad; 
		//this.gender = genero;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}