package ejercicio3.v2;

public final class InventarioServicio {
	private Inventario stock = new Inventario();//Esta es la inyección por campo?

    /*public void setStack (Inventario stack) {
        this.stack = stack;
    }*/

    public void mostrarInventario() {
    	if (stock == null) {
			System.out.println("SIN INVENTARIO.");
			return;
		}
    	else {
			System.out.println("INVENTARIO:");
			for (Producto m : stock.obtenerInventario()) {
				System.out.println(m);
			}
        }
    }
    
    public void reduceStock (String nombreFarmaco, StringBuilder gramaje, StringBuilder precio, int cantidad) {//String nombreFarmaco, StringBuilder gramaje, StringBuilder precio, int cantidad
    	Producto producto = stock.buscarProducto(nombreFarmaco);
    	if (producto != null && producto.getCant() >= cantidad) {
			producto.reducirCantidad(cantidad);
			System.out.println("Menos " + cantidad + "unidades de" + nombreFarmaco);
		}
    	else {
			System.out.println("No hay existencias de " + nombreFarmaco);
		}
    }
}
