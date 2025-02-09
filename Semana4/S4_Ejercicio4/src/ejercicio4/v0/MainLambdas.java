package ejercicio4.v0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MainLambdas {
	public static void main(String[] args) {
		System.out.println("5 Lambdas V0");
		//1
		List<String> nombres = Arrays.asList("Hugo", "Paco", "Luis");
		nombres.sort(null/*(s1, s2) -> s1.length() - s2.length()*/);
		System.out.println(nombres);
		//2
		Predicate<Integer> esPar = num -> num % 2 == 0;
		System.out.println("4 es par? --> " + esPar.test(4)); // ✅ true
		System.out.println("7 es par? --> " + esPar.test(7)); // ❌ false
		//3
		List<String> frutas = Arrays.asList("Manzana", "Mango", "Kiwi");
		frutas.sort(null);
		Consumer<String> imprimir = fruta -> System.out.println(fruta);
		frutas.forEach(imprimir);
		//4
		UnaryOperator<Integer> duplicar = n -> n * 2;
		System.out.println(duplicar.apply(5));  // ✅ 10
		System.out.println(duplicar.apply(8));  // ✅ 16
		//5
		Map<String, Integer> productos = new HashMap<>();
        productos.put("Laptop", 1000);
        productos.put("Smartphone", 500);
        productos.put("Tablet", 300);
        productos.replaceAll((producto, precio) -> precio - (precio * 10 / 100));
        System.out.println(productos.values());
		}
	}	

