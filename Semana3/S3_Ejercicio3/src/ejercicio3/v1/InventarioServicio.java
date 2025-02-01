package ejercicio3.v1;

public final class InventarioServicio {
				
	private Inventario stack;

    public void setStack (Inventario stack) {
        this.stack = stack;
    }

    public void mostrarInventario() {
    	if (stack == null) {
			System.out.println("SIN INVENTARIO.");
			return;
		}
    	else {
			System.out.println("INVENTARIO:");
			for (Producto m : stack.obtenerInventario()) {
				System.out.println(m);
			}
			
        }
    }
}
