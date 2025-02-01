package ejercicio5.v0;

public class Estudiante {
	private String nombre;
	private Calculadora calculadora;
	
	public Estudiante(String nombre, Calculadora calculadora) {
		this.nombre = nombre;
		this.calculadora = calculadora;//Recibe a calculadora (Delegación)
	}
	
	public String getNombre() {
		return nombre;
	}
	
	void hacerCalculo (int a, int b) {
		int rSuma = calculadora.suma(a,b);
		System.out.println(nombre + " hace la suma de " + a + " + " + b + " = " + rSuma);
		int rResta = calculadora.resta(a,b);
		System.out.println(nombre + " hace la resta de " + a + " - " + b + " = " + rResta);
		int rMult = calculadora.mult(a,b);
		System.out.println(nombre + " hace la multiplicación de " + a + " * " + b + " = " + rMult);
	}
}
