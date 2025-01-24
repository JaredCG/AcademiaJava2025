package ejercicio4.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFarmacia {
	
	public static void main(String[] args) {
		
		System.out.println("Farmacia V0");
		//Programa de inventario para farmacia (codigo, nombre de medicina, gramaje, precio)
		
		List<Integer> inventario = new ArrayList<Integer>();
		inventario.add(1);inventario.add(2);//inventario.add(3);//Codigo del farmaco que será inmutable
		
		Scanner scanner = new Scanner(System.in);
		String nombreFarmaco = null;
		StringBuilder gramaje = new StringBuilder();
		StringBuilder precio = new StringBuilder();
		Producto prod = null;
		
		System.out.println("Total de productos: "+ inventario.size());
		System.out.println("Ingrese los siguientes datos: Nombre del farmaco, gramaje y precio");
		for (int i : inventario) {
			System.out.println("Producto "+ i + ":");
			System.out.println("Nombre:");
			String inputNombre = scanner.nextLine();
			nombreFarmaco = inputNombre;//Nombre del farmaco
			
			System.out.println("Gramaje(mg):");
			String inputGramaje = scanner.nextLine();
			gramaje = new StringBuilder(inputGramaje);
			
			System.out.println("Precio($):");
			String inputPrecio = scanner.nextLine();
			precio = new StringBuilder(inputPrecio);
			
			prod = new Producto(inventario.get(i-1), nombreFarmaco, gramaje, precio);
			//System.out.println(prod1);
		}
		scanner.close();
		
		System.out.println("INVENTARIO:");
		for (int i : inventario) {
			Producto prod1 = new Producto(prod.getId(), prod.getNombre(), prod.getGramaje(), prod.getPrecio());
			System.out.println(prod1);
		}
	}
}
