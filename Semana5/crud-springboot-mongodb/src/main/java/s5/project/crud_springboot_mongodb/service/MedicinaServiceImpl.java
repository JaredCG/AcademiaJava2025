package s5.project.crud_springboot_mongodb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import s5.project.crud_springboot_mongodb.collection.Medicina;
import s5.project.crud_springboot_mongodb.repository.MedicinaRepo;

@Service
public class MedicinaServiceImpl implements MedicinaService{
	
	@Autowired
	private MedicinaRepo medicinaRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String save(Medicina medicina) {
		medicinaRepo.save(medicina);
		return medicina.getNombre();
	}

	@Override
	public List<Medicina> getMedicinas(String Medname) {
		return medicinaRepo.findByNombre(Medname);
	}

	@Override
	public void delete(String id) {
		medicinaRepo.deleteById(id);		
	}
	
	@Override
	public List<Medicina> buscarRangoPrecios (double minP, double maxP){
		Query query = new Query();
		query.addCriteria(Criteria.where("precio").gte(minP).lte(maxP));
		return mongoTemplate.find(query, Medicina.class);
	}
}
