package s5.project.crud_springboot_mongodb.collection;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Document(collection = "fotos")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Foto {
	@Id
	private String id;
	private String nombre;
	private Binary photo;
}
