package s5.project.crud_springboot_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import s5.project.crud_springboot_mongodb.collection.Foto;

@Repository
public interface FotoRepo extends MongoRepository<Foto, String> {
	
	List<Foto> findByNombre(String fotoName);

	
	
}
