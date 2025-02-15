package s5.project.crud_springboot_mongodb.service;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;
import s5.project.crud_springboot_mongodb.collection.Foto;

public interface FotoService {
	String saveFoto (String nombre, MultipartFile file) throws IOException;
	
	Foto getFoto(String id);
}
