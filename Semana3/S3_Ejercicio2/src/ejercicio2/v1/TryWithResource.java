package ejercicio2.v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
	public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader("entrada.txt"));
            FileWriter writer = new FileWriter("salida.txt")
        ) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
