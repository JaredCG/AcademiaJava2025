package s5.project.crud_springboot_mongodb.service;

import java.io.IOException;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s5.project.crud_springboot_mongodb.collection.Foto;
import s5.project.crud_springboot_mongodb.repository.FotoRepo;

@Service
public class FotoServiceImpl implements FotoService{
	
	@Autowired
	private FotoRepo fotoRepo;
	
	@Override
	public String saveFoto(String nombre, MultipartFile file) throws IOException{
		Foto foto = new Foto();
		foto.setNombre(file.getOriginalFilename());
		foto.setPhoto(new Binary(BsonBinarySubType.BINARY,file.getBytes()));
		foto=fotoRepo.insert(foto);
		return foto.getId();
	}
	
	public Foto getFoto(String id) {
		return fotoRepo.findById(id).get();
	}
}
