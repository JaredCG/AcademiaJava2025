package s5.project.crud_springboot_mongodb.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Document(collection = "medicinas")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Medicina {
	@Id
	private String id;
	private String nombre;
	private String gramaje;
	private double precio;
	private int stock;
}
