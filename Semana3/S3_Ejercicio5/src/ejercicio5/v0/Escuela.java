package ejercicio5.v0;

public class Escuela {
	private Aula aula;
	private Estudiante estudiante;
	
	public Escuela (Estudiante estudiante) {
		this.aula = new Aula();//Creación del aula (Composición)
		this.estudiante = estudiante;//Recibe a estudiante (Agregación)
	}
	
	void inicio() {
		aula.entrar();//Uso del aula
		System.out.println("Escuela abierta, adelante " + estudiante.getNombre() + ".");
	}
}
