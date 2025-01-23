package Ejercicio3;

public class Gato implements Registro {

	String especie = "Gato";
	String nombre;
	int edad;
	
	public Gato(String nombre, int edad) {
		this.nombre = nombre;
		this.edad =edad;
	}
	
	@Override
	public String prtList1() {
		return ("		\s\s\s" + nombre + ", " + edad + " años");
	}
	
	@Override
	public String toString() {
		return "Especie: " + especie +  " ---- Nombre y edad:";
	}
}
