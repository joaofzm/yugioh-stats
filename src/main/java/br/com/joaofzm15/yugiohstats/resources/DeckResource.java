package br.com.joaofzm15.yugiohstats.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.yugiohstats.entitites.Deck;
import br.com.joaofzm15.yugiohstats.services.DeckService;

//RequestMapping value is the URL to access this
@RestController
@RequestMapping(value = "/decks")
public class DeckResource {
	
	@Autowired
	private DeckService service;
	
	//Returns answers of web requisitions
	@GetMapping
	public ResponseEntity<List<Deck>> findAll(){
		List<Deck> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Deck> findById(@PathVariable Long id){
		Deck obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
