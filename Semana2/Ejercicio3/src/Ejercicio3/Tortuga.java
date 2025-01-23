package Ejercicio3;

public class Tortuga implements Registro {

	String especie = "Tortuga";
	String nombre;
	int edad;
	
	public Tortuga(String nombre, int edad) {
		this.nombre = nombre;
		this.edad =edad;
	}
	
	@Override
	public String prtList1() {
		return ("		\s\s\s" + nombre + ", " + edad + " años");
	}
	
	@Override
	public String toString() {
		return "Especie: " + especie +  " - Nombre y edad:";
	}
}
