package ejercicio2.v0;

import java.util.Objects;

public class Usuario {
	final Long id;
	final String nombre;

	public Usuario(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId () {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Usuario otro = (Usuario) o;
		return Objects.equals(id, otro.id) && Objects.equals(nombre, otro.nombre);
	}
}
