package br.com.joaofzm15.yugiohstats.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.yugiohstats.entitites.Duel;
import br.com.joaofzm15.yugiohstats.services.DuelService;

//RequestMapping value is the URL to access this
@RestController
@RequestMapping(value = "/duels")
public class DuelResource {
	
	@Autowired
	private DuelService service;
	
	//Returns answers of web requisitions
	@GetMapping
	public ResponseEntity<List<Duel>> findAll(){
		List<Duel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Duel> findById(@PathVariable Long id){
		Duel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
