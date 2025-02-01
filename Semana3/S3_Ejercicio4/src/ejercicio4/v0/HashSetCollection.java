package ejercicio4.v0;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetCollection {
    public static void main(String[] args) {
    	System.out.println("HashSetCollection V0");
        // Crear un HashSet para almacenar objetos Persona
        //HashSet<Animal> patos = new HashSet<>();

        // Agregar objetos al HashSet
        Animal R1 = new Animal("Rosita", 12);
        Animal H1 =new Animal("Hugo", 11);
        Animal P1 =new Animal("Paco", 11);
        Animal L1 =new Animal("Luis", 11); // Mismo nombre y edad, debe ser detectado como duplicado
        Animal D1 =new Animal("Donald", 33);
        Animal D2 =new Animal("Donald", 33);
        Animal H2 =new Animal("Hugo", 11);
        
        //System.out.println(D1.equals(D2));
        List<Animal> patos = List.of(R1,H1,P1,L1,D1,D2,H2);
        
        // Mostrar el contenido del HashSet
        System.out.println("Lista completa de Patos:");
        for (Animal p : patos) {
            System.out.println(p);
        }

        // Verificar si un objeto está en el HashSet
        Animal buscarPato1 = new Animal("Rosita", 12);
        if (patos.contains(buscarPato1)) {
            System.out.println("\nRosita sí existe.");
        } else {
            System.out.println("\nNo se encontró a Rosita.");
        }
        
        System.out.println("\nHashSet:");
        Set<Animal> setPatos = new HashSet<>(patos);
        setPatos.remove(new Animal("Rosita", 12));
        setPatos.forEach(s -> System.out.println(s));
        
        Animal buscarPato2 = new Animal("Rosita", 12);
        if (setPatos.contains(buscarPato2)) {
            System.out.println("\nRosita sí existe.");
        } else {
            System.out.println("\nNo se encontró a Rosita.");
        }
    }
}
