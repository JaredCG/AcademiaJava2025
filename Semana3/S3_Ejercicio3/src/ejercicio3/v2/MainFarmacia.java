package ejercicio3.v2;
//Inyección de dependencias por Campo
public class MainFarmacia {
	public static void main(String[] args) {
		//Inventario inventario = new Inventario();
        InventarioServicio servicio = new InventarioServicio();//Dependencia dentro de la clase
        //servicio.setStack(inventario);

        servicio.mostrarInventario();
	}
}
