package s5.project.crud_springboot_mongodb.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.models.Model;
import s5.project.crud_springboot_mongodb.collection.Foto;
import s5.project.crud_springboot_mongodb.collection.Medicina;
import s5.project.crud_springboot_mongodb.service.FotoService;
import s5.project.crud_springboot_mongodb.service.MedicinaService;

@RestController
@RequestMapping("/medicinas")
public class MedicinaController {
		
	@Autowired
	private MedicinaService medicinaService;
	
	@Autowired
	private FotoService fotoService;
	
	@PostMapping
	public String save (@RequestBody Medicina medicina) {
		return medicinaService.save(medicina);
	}
	
	@GetMapping
	public List<Medicina> getMedicinas(@RequestParam String name){
		return medicinaService.getMedicinas(name);
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable String id) {
		medicinaService.delete(id);
	}
	
	@GetMapping("/rangoprecios")
	public List<Medicina> buscarRangoPrecios(@RequestParam double minP, double maxP){
		return medicinaService.buscarRangoPrecios(minP,maxP);
	}
	
	@PostMapping(value = "/foto/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> saveFoto(@RequestParam("nombre") String nombre,@RequestParam("photo") MultipartFile file) throws IOException {
		try {
			String uploadFoto = fotoService.saveFoto(nombre, file);
			return ResponseEntity.ok().body(Map.of("message",
													"Foto subidda",
													"fotoId",
													uploadFoto.toString()));
		} catch (IOException e) {
			return ResponseEntity.badRequest().body(Map.of("Error","No se pudo guardar la imagen"));
		}
	}
		
	/*@PostMapping(value= "/fotos/add", consumes = MediaType.MULTIPART_FORM_DATA)
	public String saveFoto(@RequestParam("nombre") String nombre,@RequestParam("photo") MultipartFile file) throws IOException {
		String id = fotoService.saveFoto(nombre, file);
		return "redirect:/photos/"+id;
	}*/
	
	@GetMapping("/fotos/{id}")
    public ResponseEntity<?> getFoto(@PathVariable String id) {
        Foto photo = fotoService.getFoto(id);
        if (photo == null || photo.getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }
        
        String base64Image = Base64.getEncoder().encodeToString(photo.getPhoto().getData());
        return ResponseEntity.ok().body(
            Map.of(
                "title", photo.getNombre(),
                "image", base64Image
            )
        );
    }
//	@GetMapping("/photos/{id}")
//	public String getFoto(@PathVariable String id, Model model) {
//	    Foto photo = fotoService.getFoto(id);
//	    model.addAttribute("title", photo.getNombre());
//	    model.addAttribute("image", 
//	      Base64.getEncoder().encodeToString(photo.getPhoto().getData()));
//	    return "photos";
//	}
}
