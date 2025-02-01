package ejercicio3.v2;

import java.util.ArrayList;
import java.util.List;

public final class Inventario {
						//Medicamento
	private final List<Producto> inventario = new ArrayList<>();
	
	public Inventario() {
		inventario.add(new Producto("Paracetamol",
									new StringBuilder("500mg"),
									new StringBuilder("$30"),
									32));
	    inventario.add(new Producto("Ibuprofeno",
	    							new StringBuilder("600mg"),
	    							new StringBuilder("$50"),
	    							35));
	    inventario.add(new Producto("Amoxicilina",
	    							new StringBuilder("250mg"),
	    							new StringBuilder("$130"),
	    							48));}
							
	public List<Producto> obtenerInventario() {
		return inventario;
		}
			
	public Producto buscarProducto(String nombre) {
		return inventario.stream()
						.filter(m -> m
						.getNombre()
						.equalsIgnoreCase(nombre))
						.findFirst()
						.orElse(null);}
}
