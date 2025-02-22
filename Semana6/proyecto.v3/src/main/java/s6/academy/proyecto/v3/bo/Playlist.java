package s6.academy.proyecto.v3.bo;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@Document("playlists")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
	
	@Id
	private String playlistId;
	private String playlistNombre;
	//private int countSongs;
	//private String duracion;
	private List<String> plCanciones = new ArrayList<>();//O guardar solo las ids de las canciones con private List<String> songsIds;?
}
