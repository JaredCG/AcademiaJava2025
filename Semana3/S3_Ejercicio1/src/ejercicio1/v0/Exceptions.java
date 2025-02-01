package ejercicio1.v0;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
	
	public static void main(String[] args) {
        try {
        	
        	/*Class<String> clase = String.class;
        	Method sumaNumeros = clase.getMethod("a");
        	System.out.println(sumaNumeros(0, 0));*/
        	
        	Scanner scanner = new Scanner(System.in); 
        
			System.out.println("Primer numero:");
        	int n1 = scanner.nextInt();
            
            System.out.println("Segundo numero:");
        	int n2 = scanner.nextInt();

            // Simular un valor nulo
            Integer numeroNulo = 1;//con null sale Unchecked Exception 2: NullPointerException
            if (numeroNulo + 1 > 0) { 
                System.out.println("Ejecución continua como se espera...");
            }
            
            scanner.close();

            // Realizar la suma
            int resultado = n1+n2;
            //int resultado2 = sumaNumeros(n1, n2);

            System.out.println("El resultado es " + resultado);
        
        }catch (InputMismatchException e) {
        	System.out.println("Error: Entrada invalida. Debe ser un número entero (Unchecked).");// Unchecked Exception 1
		}catch (NullPointerException e) {
            System.out.println("Error: Valor nulo detectado (Unchecked)."); // Unchecked Exception 2
        } /*catch (NoSuchMethodException e) {
        	System.out.println("Error: a (Checked).");
			//e.printStackTrace();
		}catch (NoSuchMethodException e) {
        	System.out.println("Error: a (Checked).");
			//e.printStackTrace();*/  
    }

	/*private static int sumaNumeros(int n1, int n2) {
		if (n1 == Integer.MAX_VALUE && n2 > 0) {
			throw new ArithmeticException("Overflow al sumar los números.");
		}
		return n1 + n2;
	}*/

}
