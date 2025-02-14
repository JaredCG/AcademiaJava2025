package s5.project.crud_springboot_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import s5.project.crud_springboot_mongodb.collection.Medicina;

@Repository
public interface MedicinaRepo extends MongoRepository<Medicina, String> {
	List<Medicina> findByNombre(String MedName);
	
	//void delete(String id);//Borrar esto?
}
