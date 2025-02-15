package s5.project.crud_springboot_mongodb.service;

import java.util.List;

import s5.project.crud_springboot_mongodb.collection.Medicina;

public interface MedicinaService {
	String save (Medicina medicina);
	
	List<Medicina> getMedicinas(String Medname);
	
	void delete(String id);	
	
	List<Medicina> buscarRangoPrecios (double minP, double maxP);
}
