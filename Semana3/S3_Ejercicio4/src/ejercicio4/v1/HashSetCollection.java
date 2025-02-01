package ejercicio4.v1;

import java.util.HashSet;

public class HashSetCollection {
    public static void main(String[] args) {
    	System.out.println("HashSetCollection V1");
        // Crear un HashSet para almacenar objetos Persona
        HashSet<Animal> patos = new HashSet<>();

        // Agregar objetos al HashSet
        patos.add(new Animal("Rosita", 12));
        patos.add(new Animal("Hugo", 11));
        patos.add(new Animal("Paco", 11));
        patos.add(new Animal("Luis", 11)); 
        patos.add(new Animal("Donald", 33));

        // Mostrar el contenido del HashSet
        System.out.println("Elementos en el HashSet:");
        for (Animal p : patos) {
            System.out.println(p);
        }

        // Verificar si un objeto está en el HashSet
        Animal personaBuscar = new Animal("Rosita", 12);
        if (patos.contains(personaBuscar)) {
            System.out.println("\nRosita sí existe.");
        } else {
            System.out.println("\nNo se encontró a Rosita.");
        }
    }
}
