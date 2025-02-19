package s6.academy.proyecto.v3.bo;

import java.util.*;

import lombok.Data;

@Data
public class Playlist {
	
	private String playlistNombre;
	private int countSongs;
	private String duracion;
	private List<Cancion> canciones = new ArrayList<>();

//	public Playlist(String nombre) {
//		this.playlistNombre = nombre;
//		}
//
//	public void agregarCancion(Cancion cancion) {
//		canciones.add(cancion);
//	}

//	public void reproducirPlaylist() {
//		System.out.println("▶ Reproduciendo playlist: " + nombre);
//		for (Cancion c : canciones) {
//			c.reproducir();
//		}
//	}

    //public List<Cancion> getCanciones() { return canciones; }
}
