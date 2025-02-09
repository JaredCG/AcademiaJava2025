package ejercicio3.v0;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainFarmacia {
    public static void main(String[] args) {
        System.out.println("PROGRAMA PREDICATE V0");
        List<Producto> inventario = Arrays.asList(
            new Producto("Paracetamol", 5.0, true),
            new Producto("Ibuprofeno", 8.5, false),
            new Producto("Omeprazol", 12.0, true),
            new Producto("Amoxicilina", 15.0, true),
            new Producto("Aspirina", 6.0, false)
        );

        
        Predicate<Producto> estaDisponible = Producto::isDisponible;

        
        Predicate<Producto> esBarato = medicamento -> medicamento.getPrecio() < 10;

        
        Predicate<Producto> esCaro = medicamento -> medicamento.getPrecio() >= 10;

        List<Producto> disponibles = inventario.stream()
                                                  .filter(estaDisponible)
                                                  .collect(Collectors.toList());
        System.out.println("Medicamentos disponibles:\n" + disponibles + "\n");

        List<Producto> baratos = inventario.stream()
                                              .filter(esBarato)
                                              .collect(Collectors.toList());
        System.out.println("Medicamentos baratos:\n" + baratos + "\n");

        List<Producto> carosYDisponibles = inventario.stream()
                                                        .filter(estaDisponible.and(esCaro))
                                                        .collect(Collectors.toList());
        System.out.println("Medicamentos caros y disponibles:\n" + carosYDisponibles + "\n");

        List<Producto> baratosODisponibles = inventario.stream()
                                                          .filter(esBarato.or(estaDisponible))
                                                          .collect(Collectors.toList());
        System.out.println("Medicamentos baratos o disponibles:\n" + baratosODisponibles + "\n");

        List<Producto> noDisponibles = inventario.stream()
                                                    .filter(estaDisponible.negate())
                                                    .collect(Collectors.toList());
        System.out.println("Medicamentos NO disponibles:\n" + noDisponibles + "\n");
    }
}