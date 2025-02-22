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
import s6.academy.proyecto.v3.repository.CancionRepo;
import s6.academy.proyecto.v3.repository.PlaylistRepo;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	private PlaylistRepo playlistRepo;
	
	@Autowired
	private CancionRepo cancionRepo;
	
//	@Autowired
//	private CancionService cancionService;
//	
//	@Autowired
//	private MongoTemplate mongoTemplate;

//	@Override
//	public String save(Playlist playlist) {
//		playlist.setCanciones(List.of());
//		playlistRepo.save(playlist);
//		return playlist.getPlaylistNombre();
//	}
	
	@Override
	public Playlist save(String playlistId,String playlistNombre) {
		Playlist playlist = new Playlist();
		playlist.setPlaylistId(playlistId);
		playlist.setPlaylistNombre(playlistNombre);
        playlist.setPlCanciones(List.of()); // Inicia vacía	
        return playlistRepo.save(playlist);
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
	public Playlist addSong(String playlistId, String songId) {
		Optional<Playlist> playlistOptional = playlistRepo.findById(playlistId);
		Optional<Cancion> cancionOptional = cancionRepo.findById(songId);
		if (playlistOptional.isPresent() && cancionOptional.isPresent()) {
            Playlist playlist = playlistOptional.get();
            if (!playlist.getPlCanciones().contains(songId)) {
				playlist.getPlCanciones().add(songId);
			}
            return playlistRepo.save(playlist);
        } else {	
            throw new RuntimeException("Playlist o canción no encontrada");
        }
	}

	@Override
	public List<Cancion> getSongsPL(String playlistId) {
		Optional<Playlist> playlistOptional = playlistRepo.findById(playlistId);
		if (playlistOptional.isPresent()) {
			Playlist playlist = playlistOptional.get();
			List<String> canciones = playlist.getPlCanciones();
			return cancionRepo.findAllById(canciones);
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
