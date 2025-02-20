package s6.academy.proyecto.v3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import s6.academy.proyecto.v3.bo.Cancion;
import s6.academy.proyecto.v3.bo.Playlist;
import s6.academy.proyecto.v3.repository.PlaylistRepo;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistRepo playlistRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String save(Playlist playlist) {
		playlistRepo.save(playlist);
		return playlist.getPlaylistNombre();
	}

	@Override
	public List<Playlist> getPlaylists() {
		return playlistRepo.findAll();
	}

	@Override
	public void delete(String playlistId) {
		playlistRepo.deleteById(playlistId);
	}

	@Override
	public String addSong(String playlistId, String songId) {
		Optional<Playlist> playlistOptional1 = playlistRepo.findById(playlistId);
		//Optional<Cancion> cancionOptional = can
		return null;
	}

	@Override
	public List<Cancion> getSongsPL(String plName) {
		Optional<Playlist> playlistOptional2 = playlistRepo.findById(plName);
		if (playlistOptional2.isPresent()) {
			List<Cancion> canciones = playlistOptional2.get().getCanciones();
			return null;
		}else {
			throw new RuntimeException("Playlist no encontrada");
		}
	}

//	@Override
//	public List<Cancion> getRangoDuracion(double minD, double maxD) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("duracion").gte(minD).lte(maxD));
//		return mongoTemplate.find(query, Cancion.class);
//	}
	
}
