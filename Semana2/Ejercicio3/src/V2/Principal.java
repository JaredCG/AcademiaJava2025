package V2;

import java.util.Arrays;
import java.util.List;

public class Principal {
	
	/*static boolean rgstrEspecie(Especie re) {
		for (Especie e : re) {
			if (e.equals(re)) {
				return true;
			}
		}
		return false;
	}*/
	
	public static void main (String [] args) {
		
		System.out.println("Veterinaria");
		Registro[] rgstr = { new Perro("Morty", 6),
						new Perro("Kirino", 11),
						/*new Gato("Mandarino", 1),
						new Tortuga("Tuck", 43),
						
						new Pescado(),
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
