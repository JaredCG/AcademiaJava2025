package ejercicio3.v1;
//Inyección de dependencias por Setters
public class MainFarmacia {

	public static void main(String[] args) {
		Inventario inventario = new Inventario();
        //
		InventarioServicio servicio = new InventarioServicio();
        servicio.setStack(inventario);
        //
        servicio.mostrarInventario();
	}
}
