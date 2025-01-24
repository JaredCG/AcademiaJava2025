package ejercicio4.v1;

public final class Producto {
	
	private final int id;
	//private final List<Integer> id;
	private final String nombreFarmaco;
	private final StringBuilder gramaje;
	private final StringBuilder precio;
	
	public Producto(/*List<Integer> inventario*/int inventario, String nombreFarmaco, StringBuilder gramaje, StringBuilder precio) {
		
		this.id = inventario;
		this.nombreFarmaco = nombreFarmaco;
		this.gramaje = gramaje;
		this.precio = precio;
	}
	
	public /*List<Integer>*/int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombreFarmaco;
	}
	
	public StringBuilder getGramaje() {
		return gramaje;
	}
	
	public StringBuilder getPrecio() {
		return precio;
	}
	
	@Override
	public String toString() {
		return "Código: " + id + " | Producto: " + nombreFarmaco + " | Gramaje: " + gramaje + "mg | Precio: $" + precio;
	}
}
