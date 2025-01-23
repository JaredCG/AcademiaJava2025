package Ejercicio3;

import java.util.Arrays;
import java.util.List;

public class Principal {
	
	public static void main (String [] args) {
		
		System.out.println("Veterinaria");
		Registro[] rgstr = { new Perro("Akina", 4),
						new Gato("Mandarino", 1),
						new Tortuga("Tuck", 43),
						new Perro("Kirino", 11),
						/*new Pescado(),
						new Hamster()*/};
		
		List<Registro> lista = Arrays.asList(rgstr);
		for(Registro l : lista)
			prtList(l);
		
	}
	static void prtList(Registro r) {
		System.out.println(r);
		System.out.println(r.prtList1());
		//System.out.println(r.prtList2());
	}

}
