package s6.academy.proyecto.v3.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import s6.academy.proyecto.v3.bo.Playlist;

@Repository
public interface PlaylistRepo extends MongoRepository<Playlist, String> {
	//List<Playlist> findById();
}
