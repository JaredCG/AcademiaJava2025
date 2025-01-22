package Ejercicio1;

import java.util.ArrayList;

public class noEsSpotify {
	
	//private String[] biblioteca;
	private ArrayList<String> biblioteca;
	/*private int contadorC;//contador numero de canciones
    public noEsSpotify(int capacidad) {
    	biblioteca = new String[capacidad];
        contadorC = 0;
    }*/
	public noEsSpotify() {
		biblioteca = new ArrayList<>();
	}
    
    public void agregarCancion(String cancion) {
    	biblioteca.add(cancion);
    	System.out.println("Cancion agregada: " + cancion);
    	/*if (contadorC < biblioteca.length) {
    		biblioteca[contadorC++] = cancion;
            System.out.println("Cancion agregada: " + cancion);
        } else {
            System.out.println("La biblioteca está llena, no se puede agregar más canciones.");
        }*/
    }
    
    public void mostrarCanciones() {
    	System.out.println("Canciones en la biblioteca:");
    	for(int i = 0; i < biblioteca.size(); i++) {
    		System.out.println((i + 1) + ". " + biblioteca.get(i));
    	}
        /*for (int i = 0; i < contadorC; i++) {
        	System.out.println((i + 1) + ". " + biblioteca[i]);
        }*/
    }

    public static void main(String[] args) {
    	noEsSpotify biblioteca = new noEsSpotify();
        biblioteca.agregarCancion("Hurt");
        biblioteca.agregarCancion("Mago");
        biblioteca.mostrarCanciones();
    }

}
