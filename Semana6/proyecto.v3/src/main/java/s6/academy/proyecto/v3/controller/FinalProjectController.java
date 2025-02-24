package s6.academy.proyecto.v3.controller;

import com.mongodb.bulk.BulkWriteResult;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import s6.academy.proyecto.v3.bo.Cancion;
import s6.academy.proyecto.v3.bo.Playlist;
import s6.academy.proyecto.v3.service.CancionService;
import s6.academy.proyecto.v3.service.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musica")
public class FinalProjectController {

    @Value("${file.input}")
    private String fileInput;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private CancionService cancionService;
    
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/mongodbbulkupdate")
    public String directHomePage() {
        try {
            commitBulkUpdateToMongoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mongodb Bulk Update Processed";
    }
    /*Bulk Update de MongoDB lee e inserta la info del CSV para luego subirlo/actualizarlo con el primer GetMapping  */
    private void commitBulkUpdateToMongoDB() {
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        	CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        	CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();
            int count = 0;
            Cancion productData = null;
            List<Cancion> productInfoList = new ArrayList<>();

            for (String[] productRow : allData) {
                String[] productStringArry = new String[productRow.length];
                productData = new Cancion();
                count = 0;
                for (String productInfo : productRow) {
                    productStringArry[count] = productInfo;
                    count++;
                }
                productData.setSongId(productStringArry[0]);
                productData.setTitulo(productStringArry[1]);
                productData.setArtista(productStringArry[2]);
                productData.setAlbum(productStringArry[3]);
                productData.setGenero(productStringArry[4]);
                productData.setDuracion(productStringArry[5]);
                productInfoList.add(productData);
            }

            BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Cancion.class);
            productInfoList.stream().filter(product -> product != null).forEach(product -> {
                org.bson.Document dbDoc = new org.bson.Document().append("$set", product);
                mongoTemplate.getConverter().write(product, dbDoc);
                Query query = new Query().addCriteria(new Criteria("uuid").is(product.getSongId()));
                Update update = Update.fromDocument(dbDoc, "");
                bulkOps.upsert(query, update);
            });

            BulkWriteResult result = bulkOps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping("/canciones")//Mostrar todas las canciones subidas a la BD
	public List<Cancion> getCanciones(){
		return cancionService.getCanciones();
	}
    
    @GetMapping("/cancion")//Mostrar la cancion solicitada a través del titulo de la cancion
	public List<Cancion> getCancion(@RequestParam String name){
		return cancionService.getCancion(name);
	}
	
	@DeleteMapping("/deletesong/{songId}")//Eliminar una cancion usando su ObjectId
	public void deleteSong (@PathVariable String songId) {
		cancionService.delete(songId);
	}
	
	@GetMapping("/rangoduracion")//Mostrar canciones dentro de un rango de duracion
	public List<Cancion> getRangoDuracion(@RequestParam double min, double max){
		return cancionService.getRangoDuracion(min,max);
	}
	
	@PatchMapping("/cancion/{songId}")//Parchar/modificar los datos de una cancion solicitda a través de su ObjectId
    public Cancion updateCancion(@PathVariable String songId, @RequestBody Cancion cancionBody) {
        return cancionService.updateCancion(songId, cancionBody);
    }
	
	
	/********************METODOS PARA PLAYLIST*****************/
	@PostMapping("/crearplaylist")//Crear una playlist con su id y nombre
	public /*String*/Playlist save(@RequestParam /*Playlist*/String playlistId,@RequestParam String playlistNombre) {
		
		return playlistService.save(playlistId, playlistNombre);
	}
	
//	@PostMapping("/crearplaylist")//Otra manera para crear la playlist
//	public String save(@RequestBody Playlist playlist) {
//		
//		return playlistService.save(playlist);
//	}
	
	@GetMapping("/playlists")//Mostrar todas las playlists creadas
	public List<Playlist> getPlaylists(){
		return playlistService.getPlaylists();
	}
	
	@DeleteMapping("/deleteplaylist/{playlistId}")//Eliminar una cancion solicitando su id
	public void deletePlaylist (@PathVariable String playlistId) {
		playlistService.delete(playlistId);
	}
	
	@PostMapping("/{playlistId}/agregarcancion")//Agregar una cancion a una playlist usando sus ids
    public Playlist addSongToPlaylist(@PathVariable String playlistId, @RequestParam String cancionId) {
        return playlistService.addSong(playlistId, cancionId);
    }
	
	@GetMapping("/{playlistId}/songslist")//Mostrar canciones dentro de la playlist solicitada
	public List<Cancion> getSongsFromPlaylist(@PathVariable String playlistId){
		return playlistService.getSongsPL(playlistId);
	}
}
