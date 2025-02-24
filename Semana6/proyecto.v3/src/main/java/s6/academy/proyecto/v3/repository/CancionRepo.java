package s6.academy.proyecto.v3.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import s6.academy.proyecto.v3.bo.Cancion;

@Repository
public interface CancionRepo extends MongoRepository<Cancion, String> {
//	List<Cancion> getAll();
	List<Cancion> findByTitulo(String songName);//"findBy***** para el crudrepository"
}
