package ejercicio4.v1;

import java.util.Objects;

public class Animal {
	
	private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true; // Si es la misma referencia, son iguales
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        Animal otro = (Animal) obj;
        return Objects.equals(nombre, otro.nombre) && Objects.equals(edad, otro.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + "', edad=" + edad + '}';
    }

}
