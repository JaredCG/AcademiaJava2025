package ejercicio1.v1;

public class Hola<T,U> {
	private T uno;
	private U dos;

    public void agregar(T contenido1, U contenido2) {
        this.uno = contenido1;
        this.dos = contenido2;
    }

    public T getUno() {
        return uno;
    }
    
    public U getDos() {
        return dos;
    }
    
    /*@Override
    public boolean equals(Object obj) {//Object obj
    	if (this == obj) 
        	return true; // Si es la misma referencia, son iguales
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        //Hola<T,U> otro = (Hola<T,U>) obj;
        return Objects.equals(uno, otro.uno) && Objects.equals(dos, otro.dos);
    }*/
    
    @Override
    public String toString() {
    	return "" + uno + " " + dos;
    }
}
