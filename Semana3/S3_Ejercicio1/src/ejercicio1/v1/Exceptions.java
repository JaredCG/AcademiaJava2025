package ejercicio1.v1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
	
	public static void main(String[] args)  {
		System.out.println("Exceptions V1");
		Scanner scanner = new Scanner(System.in);
		try {
        	
            // Checked Exception 1: Leer números desde un archivo (puede lanzar IOException)
            int numero1 = leerNumeroDesdeArchivo("C:/Users/VOSTRO 3400/eclipse-workspace/AcademiaJava2025/Semana3/S3_Ejercicio1/src/ejercicio1/v1/numero1.txt");
            System.out.println("Numero en primer archivo: " + numero1);
            int numero2 = leerNumeroDesdeArchivo("C:/Users/VOSTRO 3400/eclipse-workspace/AcademiaJava2025/Semana3/S3_Ejercicio1/src/ejercicio1/v1/numero2.txt");
            System.out.println("Numero en segundo archivo: " + numero2);
            
            System.out.println("Ingrese el nombre del tercer archivo:");
            String archivo3 = scanner.nextLine();//Escribir "C:/Users/VOSTRO 3400/eclipse-workspace/AcademiaJava2025/Semana3/S3_Ejercicio1/src/ejercicio1/v1/numero3.txt"
            
            int numero3 = buscarArchivo(archivo3); // Puede lanzar FileNotFoundException
            System.out.println("Número en tercer archivo: " + numero3);
            
            // Unchecked Exception 1: Simular un valor nulo
            Integer numeroNulo = 1;
            if (numeroNulo + 1 > 0) { // Esto genera NullPointerException
                System.out.println("Ejecución continua como se espera...");
            }
            
            // Realizar la suma
            int resultado = sumaNumeros(numero1, numero2);
           // System.out.println("Numero en tercer archivo: " + numero3);
            System.out.println("El resultado es " + resultado);

        } catch (FileNotFoundException e) {
        	System.out.println("Error: No se encontró el archivo: " + e.getMessage() + " (Checked).");
		}catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage() + " (Checked)"); // Checked Exception 1
        } catch (NumberFormatException e) {
            System.out.println("Error: El archivo contiene datos no válidos (Unchecked)."); // Unchecked Exception 2 (propiamente designación )
        } catch (InputMismatchException e) {
        	System.out.println("Error: El archivo contiene datos no válidos (Unchecked).");
		} catch (NullPointerException e) {
        	System.out.println("Error: Se intentó usar un valor nulo (Unchecked)."); // Unchecked Exception 1
        } finally {
			scanner.close();
		}
	}
	
	private static int sumaNumeros(int a, int b) {
        if (a == Integer.MAX_VALUE && b > 0) {
            throw new ArithmeticException("Overflow al sumar los números.");
        }
        return a + b;
    }

	// Método para leer un número desde un archivo
	private static int leerNumeroDesdeArchivo(String nombreArchivo) throws IOException {
		//try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(nombreArchivo))) {
			return Integer.parseInt(reader.readLine().trim()); // Puede lanzar NumberFormatException (Unchecked)
		}
	}

	public static int buscarArchivo(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);
        
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo " + nombreArchivo + " no existe.");
        }

        try (Scanner scanner = new Scanner(archivo)) {
            return scanner.nextInt(); // Lee el número dentro del archivo
        }
	}
}
