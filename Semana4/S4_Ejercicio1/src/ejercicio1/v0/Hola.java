package ejercicio1.v0;

public class Hola<T> {
	private T contenido;

    public void agregar(T contenido) {
        this.contenido = contenido;
    }

    public T obtener() {
        return contenido;
    }
}
