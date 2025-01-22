package Ejercicio2;

import java.util.Scanner;

public class Calificaciones {
	
	// Método sobrecargado para calcular calificaciones con valor redondeado (usando Integer)
    public static int calcularCalificacion(Integer nota) {
        if (nota >= 95) return 10;
        if (nota >= 85 && nota < 95) return 9;
        if (nota >= 75 && nota < 85) return 8;
        if (nota >= 65 && nota < 75) return 7;
        if (nota >= 55 && nota < 65) return 6;
        return /*"F"*/5;
    }

    // Método sobrecargado para calcular calificaciones con un promedio de varias notas (Double)
    public static double calcularCalificacion(Double promedio) {
        return calcularCalificacion(promedio.intValue());//Unboxing de Double a int
    }

    // Método sobrecargado para mostrar una calificación (usando Integer)
    public static void mostrarCalificacion(Integer redondeado) {
        System.out.println("La calificación final: " + redondeado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de calificaciones.");
        System.out.print("¿Cuántas notas deseas ingresar? ");
        int cantidadNotas = scanner.nextInt();

        Double suma = 0.0; // Usamos Double (Wrapper Class/autoboxing de double primitivo) para sumar las notas
        for (int i = 1; i <= cantidadNotas; i++) {//Ingreso manual de calificaciones del 0 al 100
            System.out.print("Introduce la nota " + i + " (0-100): ");
            Integer nota = scanner.nextInt(); // Usamos Integer (Wrapper Class/autoboxing de int primitivo) para capturar las notas
            suma += nota;/////Unboxing y autoboxing "al mismo tiempo"?
        }

        // Calcular el promedio
        Double promedio = suma / cantidadNotas;/////Unboxing y autoboxing "al mismo tiempo"?
        System.out.println("Calificacion promedio: " + promedio);

        // Determinar la calificación final
        double calificacion = calcularCalificacion(promedio);

        // Mostrar la calificación final
        mostrarCalificacion((int) calificacion); // Casteamos de double a int para mostrar la calificación final

        scanner.close();
    }
}
