package s6.academy.proyecto.v3.bo;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("playlists")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
	
	@Id
	private String playlistId;
	private String playlistNombre;
	private int countSongs;
	private String duracion;
	private List<Cancion> canciones = new ArrayList<>();//O guardar solo las ids de las canciones con private List<String> songsIds;?

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
