package ejercicio4.v0;

import java.util.ArrayList;
import java.util.List;

public class MainFarmacia {
	
	public static void main(String[] args) {
		
		System.out.println("Farmacia V0");
		//Programa de inventario para farmacia (codigo, nombre de medicina, gramaje, precio)
		
		List<Integer> inventario = new ArrayList<Integer>();
		
		inventario.add(1);inventario.add(2);inventario.add(3);//Codigo del farmaco que será inmutable

		System.out.println("Total de productos: "+ inventario.size());
		//System.out.println(inventario.get(0));
		String nombreFarmaco = "Paracetamol";//Nombre del farmaco
		StringBuilder gramaje = new StringBuilder("500mg");
		StringBuilder precio = new StringBuilder("$30");
		
		//List<Integer> lista = Arrays.asList(inventario);
		System.out.println("INVENTARIO:");
		for (int i : inventario) {
			Producto prod1 = new Producto(inventario.get(i-1), nombreFarmaco, gramaje, precio);
			System.out.println(prod1);
		}
	}
}
