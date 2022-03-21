package br.com.joaofzm15.yugiohstats.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.yugiohstats.entitites.Player;

//RequestMapping value is the URL to access this
@RestController
@RequestMapping(value = "/players")
public class PlayerResource {
	
	//Returns answers of web requisitions
	@GetMapping
	public ResponseEntity<Player> findAll(){
		Player p = new Player(1L, "Revolver");
		return ResponseEntity.ok().body(p);
	}

}
