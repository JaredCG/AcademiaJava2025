package s6.academy.proyecto.v3.service;

import java.util.List;

import s6.academy.proyecto.v3.bo.Cancion;
import s6.academy.proyecto.v3.bo.Playlist;

public interface PlaylistService {
	
	//String save(Playlist playlist);
	Playlist save (String playlistId,String playlistNombre);//Crear playlist
	List<Playlist> getPlaylists ();//Mostrar todas las playlists
	void delete(String playlistId);//Eliminar playlist

	Playlist addSong (String playlistId, String songId);//Agregar cancion a playlist
	List<Cancion> getSongsPL(String plName);//Imprimir canciones de una PL
	//List<Cancion> getRangoDuracion (double minD, double maxD);//Mostrar canciones en un rango de duracion
	//Falta agregar eliminar cancion de PL
}
