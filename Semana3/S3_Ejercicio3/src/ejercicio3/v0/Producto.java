package ejercicio3.v0;

public final class Producto {
	
	
	private final String nombreFarmaco;
	private final StringBuilder gramaje;
	private final StringBuilder precio;
	private int cantidad;
	
	public Producto(String nombreFarmaco, StringBuilder gramaje, StringBuilder precio, int cantidad) {
		
		this.cantidad = cantidad;
		this.nombreFarmaco = nombreFarmaco;
		this.gramaje = gramaje;
		this.precio = precio;
	}
	
	public int getCant() {
		return cantidad;
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
		return "- " + nombreFarmaco + " (Cantidad: " + cantidad + ")\n  	Gramaje: " + gramaje + " | Precio: " + precio ;
	}
}
