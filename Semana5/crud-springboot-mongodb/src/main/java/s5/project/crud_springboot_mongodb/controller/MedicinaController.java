package s5.project.crud_springboot_mongodb.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import s5.project.crud_springboot_mongodb.collection.Medicina;
import s5.project.crud_springboot_mongodb.service.MedicinaService;

@RestController
@RequestMapping("/medicinas")
public class MedicinaController {
	
	@Autowired
	private MedicinaService medicinaService;
	
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
}
