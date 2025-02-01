package ejercicio5.v0;

public class MainEstudiar {
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		//Aula aula = new Aula();//Este dentro de Escuela
		Estudiante estudiante = new Estudiante("Juan Perez", calculadora);
		//Creación de Estudiante con Calculadora (Delegación)
		Escuela escuela = new Escuela(estudiante);
		escuela.inicio();
		estudiante.hacerCalculo(5,3);
	}
}