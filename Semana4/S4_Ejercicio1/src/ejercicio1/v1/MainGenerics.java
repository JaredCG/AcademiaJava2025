package ejercicio1.v1;

public class MainGenerics {
	public static void main(String[] args) {
		Hola<String, String> holaText1 = new Hola<>();
		Hola<String, String> holaText2 = new Hola<>();
		holaText1.agregar("Hola", "Generic");
		holaText2.agregar("Hello", "Generico");
        
		System.out.println("Texto1: " + holaText1);
		System.out.println("Texto2: " + holaText2);
        if (!holaText1.equals(holaText2)) {
        	Hola<String, String> holaText3 = new Hola<>();
        	holaText3.agregar(holaText1.getUno(), holaText2.getDos());
			System.out.println("Texto3: " + holaText3 );
		} 
        
        Implementar.imprimirElemento(123);
        Implementar.imprimirElemento("A");

        SumaInteger sumaInt = new SumaInteger();
        System.out.println("Suma de Integer: " + sumaInt.ejecutar(5, 10));

        SumaDouble sumaDouble = new SumaDouble();
        System.out.println("Suma de Double: " + sumaDouble.ejecutar(2.5, 3.7));
    }
}
