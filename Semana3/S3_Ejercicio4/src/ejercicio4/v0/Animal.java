package ejercicio4.v0;

import java.util.Objects;

public class Animal {
	
	private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrescribimos equals() para comparar objetos basados en nombre y edad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        	return true; // Si es la misma referencia, son iguales
        if (obj == null) 
        	return false;
        if (this.getClass() != obj.getClass())
        	return false;
        Animal otro = (Animal) obj;
        return Objects.equals(this.nombre, otro.nombre) && Objects.equals(this.edad, otro.edad);
        //Si nombre y edad son iguales
        //return edad == pato.edad && Objects.equals(nombre, pato.nombre);
        //Si solo nombre es igual
        //return Objects.equals(this.edad, otro.edad) && nombre == otro.nombre;
        //Si solo edad es igual
    }

    // Sobrescribimos hashCode() para generar un hash basado en nombre y edad
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    	//return nombre.hashCode();
    }

    // Impresión de información del pato
    @Override
    public String toString() {
        return "Miembro de la patofamilia --> {" + "nombre='" + nombre + "', edad=" + edad + '}';
    }

}
