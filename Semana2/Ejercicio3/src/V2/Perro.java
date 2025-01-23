package V2;

public class Perro implements Registro {

	String especie = "Perro";
	String nombre;
	int edad;
	
	public Perro(String nombre, int edad) {
		this.nombre = nombre;
		this.edad =edad;
		//edad = (int)edad;
		
	}
	
	@Override
	public String prtList1() {
		return ("		\s\s\s" + nombre + ", " + edad + " años");
	}
	
	/*@Override
	public int prtList2 () {
		System.out.println("Edad: ");
		return edad;
	}*/
	
	
	@Override
	public String toString() {
		return "Especie: " + especie +  " --- Nombre y edad:";
	}

}
