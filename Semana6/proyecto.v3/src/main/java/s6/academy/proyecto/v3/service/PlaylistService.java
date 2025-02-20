package s6.academy.proyecto.v3.service;

import java.util.List;

import s6.academy.proyecto.v3.bo.Cancion;
import s6.academy.proyecto.v3.bo.Playlist;

public interface PlaylistService {
	
	//Creacion de la Playlist, impresion de las existentes y eliminacion de un playlist
	String save(Playlist playlist);
	List<Playlist> getPlaylists ();
	void delete(String playlistId);
	
	//Agregar cancion en playlist, imprimir canciones de una playlist y eliminar cancion de una playlist
	String addSong (String playlistId, String songId);//Agregar cancion a playlist
	List<Cancion> getSongsPL(String plName);//Imprimir canciones de una PL
	//List<Cancion> getRangoDuracion (double minD, double maxD);//Mostrar canciones en un rango de duracion
	//Falta agregar eliminar cancion de PL
}
