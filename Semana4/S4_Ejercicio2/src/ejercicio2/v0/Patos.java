package ejercicio2.v0;

public class Patos {
	private String nombre;
    private Double edad;

    public Patos(String nombre, Double edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", edad: " + edad + " años";
    }
}
