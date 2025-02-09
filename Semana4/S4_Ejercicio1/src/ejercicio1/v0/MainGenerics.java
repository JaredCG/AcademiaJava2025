package ejercicio1.v0;

public class MainGenerics {
	public static void main(String[] args) {
		Hola<String> holaText = new Hola<>();
		holaText.agregar("Hola Generic");
        System.out.println("Texto: " + holaText.obtener());

        Implementar.imprimirElemento(123);
        Implementar.imprimirElemento("A");

        SumaInteger sumaInt = new SumaInteger();
        System.out.println("Suma de Integer: " + sumaInt.ejecutar(5, 10));

        SumaDouble sumaDouble = new SumaDouble();
        System.out.println("Suma de Double: " + sumaDouble.ejecutar(2.5, 3.7));
    }
}
