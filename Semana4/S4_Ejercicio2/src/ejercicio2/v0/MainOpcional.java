package ejercicio2.v0;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainOpcional {
	public static void main(String[] args) {
		System.out.println("PROGRAMA OPTIONAL");
		List<Patos> patos = Arrays.asList(new Patos("Hugo", 11.1),
											new Patos("Paco", 11.2),
											new Patos("Luis", 11.3));
		for (Patos lista : patos) {
			System.out.println(lista);
		}
		Optional<Patos> patoEncontrado = buscarPato(patos, "Rosita");
	
		if (patoEncontrado.isPresent()) {
			System.out.println("Rosita existe: " + patoEncontrado.get().getNombre());
		} else {
			System.out.println("Rosita no existe");
		}
		
		patoEncontrado.ifPresent(pato -> System.out.println("Hola, " + pato.getNombre()));

	        //Obtener al pato con orElse() si no existe
		Patos otroPato = patoEncontrado.orElse(new Patos("Rico McPato", 152.0));
	    System.out.println("Hay otro pato que no es un niño:\n" + otroPato);

	    //Obtener al pato con orElseGet() (mejor para cálculos?)
	    Patos nuevoPato = patoEncontrado.orElseGet(() -> new Patos("Rosita", 12.0));
	    System.out.println("Pato generado: " + nuevoPato);
	    

	    //Lanzar una excepción si no se encuentra con orElseThrow()
	    try {
	    	Patos patoException = patoEncontrado.orElseThrow(() -> new RuntimeException("No hay mas patos"));
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }

	    //Transformar al pato con map() (Obtener la edad si existe)
	    Optional<Double> edad = Optional.of(nuevoPato).map(Patos::getEdad);
	    System.out.println("Edad del nuevo pato: " + edad.orElse(0.0));
	    //Buscar a un pato que NO existe
	    Optional<Patos> patoNoExiste = buscarPato(patos, "Donald");
	    System.out.println("Buscar a 'Donald': " + patoNoExiste.orElse(new Patos("Desconocido", 0.0)));
	    
	    //System.out.println(patos);
	}
	
	public static Optional<Patos> buscarPato(List<Patos> lista, String nombre) {
		return lista.stream()
					.filter(pato -> pato.getNombre().equalsIgnoreCase(nombre))
					.findFirst(); //Retorna un Optional<Patos>
	}
}
