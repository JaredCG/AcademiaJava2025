package ejercicio3.v0;

public final class InventarioServicio {
				
	private final Inventario stock;

    public InventarioServicio(Inventario stack) {
        this.stock = stack;
    }

    public void mostrarInventario() {
        System.out.println("INVENTARIO:");
        for (Producto m : stock.obtenerInventario()) {
            System.out.println(m);
        }
    }
}
