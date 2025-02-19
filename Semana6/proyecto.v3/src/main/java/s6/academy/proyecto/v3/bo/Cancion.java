package s6.academy.proyecto.v3.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("canciones")
public class Cancion {
	//@Id
	private String songId;
	private String titulo;
	private String artista;
	private String album;
	private String genero;
	private String duracion;
}
