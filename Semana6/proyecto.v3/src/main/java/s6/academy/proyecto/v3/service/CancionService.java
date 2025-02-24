package s6.academy.proyecto.v3.service;

import java.util.List;

import s6.academy.proyecto.v3.bo.Cancion;

public interface CancionService {
	
	//Las canciones se guardan a través del CSV, no es necesario un metodo para POST
	List<Cancion> getCanciones();//Mostrar todas las canciones
	List<Cancion> getCancion(String songName);//Mostrar una cancion
	Cancion updateCancion (String songId, Cancion cancionBody);//Modificar cancion
	void delete(String songId);//Eliminar cancion
	
	//Imprimir canciones en un rango dado
	List<Cancion> getRangoDuracion (double minD, double maxD);//Mostrar canciones por rango de duracion
}
