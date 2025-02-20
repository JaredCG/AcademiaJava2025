package s6.academy.proyecto.v3.service;

import java.util.List;

import s6.academy.proyecto.v3.bo.Cancion;

public interface CancionService {
	
	//Las canciones se guardan a través del CSV, no es necesario un metodo para POST (creo)
	//Impresion de las canciones y eliminacion de una cancion
	List<Cancion> getCanciones();
	List<Cancion> getCancion(String songName);
//	void delete(String songId);
//	
//	//Agregar cancion en playlist, imprimir canciones de una playlist y eliminar cancion de una playlist
//	List<Cancion> getRangoDuracion (double minD, double maxD);
	//List<Cancion> getSongsPL(String plName);
}
