package ejercicio3.v0;
//Inyección de dependencias por Constructores
public class MainFarmacia {

	public static void main(String[] args) {
		Inventario inventario = new Inventario();
        //
		InventarioServicio servicio = new InventarioServicio(inventario);
		//
        servicio.mostrarInventario();
	}
}
