package ejercicio3.v0;

public class Producto {
	 private String nombre;
	    private double precio;
	    private boolean disponible;

	    public Producto(String nombre, double precio, boolean disponible) {
	        this.nombre = nombre;
	        this.precio = precio;
	        this.disponible = disponible;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public boolean isDisponible() {
	        return disponible;
	    }

	    @Override
	    public String toString() {
	        return "Nombre: " + nombre + "| precio=" + precio + "| disponible=" + disponible + "\n";
	    }
}
