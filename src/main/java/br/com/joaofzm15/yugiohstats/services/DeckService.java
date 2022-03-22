package br.com.joaofzm15.yugiohstats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.yugiohstats.entitites.Deck;
import br.com.joaofzm15.yugiohstats.repositories.DeckRepository;

@Service
public class DeckService {
	
	@Autowired
	private DeckRepository repository;
	
	public List<Deck> findAll(){
		return repository.findAll();
	}
	
	public Deck findById(Long id) {
		Optional<Deck> obj = repository.findById(id);
		return obj.get();
	}

}
