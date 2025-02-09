package ejercicio5.v0;

public class Empleado {
	
	private final String nombre;
	private final String dept;
	private final double sal;

	public Empleado(String nombre, String dept, double sal) {
		this.nombre = nombre;
		this.dept = dept;
		this.sal = sal;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDept() {
		return dept;
	}

	public double getSal() {
		return sal;
	}

	@Override
	public String toString() {
		return "Empleado --> [Nombre: " + nombre + ", dept=" + dept + ", sal=" + sal + "]";
	}

}
