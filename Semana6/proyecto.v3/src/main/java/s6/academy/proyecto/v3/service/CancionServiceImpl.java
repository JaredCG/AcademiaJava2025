package s6.academy.proyecto.v3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import s6.academy.proyecto.v3.bo.Cancion;
import s6.academy.proyecto.v3.repository.CancionRepo;

@Service
public class CancionServiceImpl implements CancionService {
	
	@Autowired
	private CancionRepo cancionRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Cancion> getCanciones() {
		return cancionRepo.findAll();
	}

	@Override
	public List<Cancion> getCancion(String songName) {
		return cancionRepo.findByTitulo(songName);
	}

	@Override
	public void delete(String songId) {
		cancionRepo.deleteById(songId);
	}
	
	@Override
	public List<Cancion> getRangoDuracion(double minD, double maxD) {
		Query query = new Query();
		query.addCriteria(Criteria.where("duracion").gte(minD).lte(maxD));
		return mongoTemplate.find(query,Cancion.class);
	}

	@Override
	public Cancion updateCancion (String songId, Cancion cancionBody) {
		
		Optional<Cancion> cancionOptional = cancionRepo.findById(songId);

        if (cancionOptional.isEmpty()) {
            throw new RuntimeException("Canción no encontrada");
        }

        Cancion modifCancion = cancionOptional.get();

        // Verifica que la canción recibida no sea null antes de acceder a sus valores
        if (cancionBody == null) {
            throw new RuntimeException("Datos inválidos para actualizar la canción");
        }

        // Solo actualizar los campos que se enviaron
        if (cancionBody.getTitulo() != null && !cancionBody.getTitulo().isEmpty()) {
        	modifCancion.setTitulo(cancionBody.getTitulo());
        }
        if (cancionBody.getArtista() != null && !cancionBody.getArtista().isEmpty()) {
        	modifCancion.setArtista(cancionBody.getArtista());
        }
        if (cancionBody.getAlbum() != null) { 
        	modifCancion.setDuracion(cancionBody.getAlbum());
        }

        return cancionRepo.save(modifCancion);
	}
}
