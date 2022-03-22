package br.com.joaofzm15.yugiohstats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.yugiohstats.entitites.Duel;
import br.com.joaofzm15.yugiohstats.repositories.DuelRepository;

@Service
public class DuelService {
	
	@Autowired
	private DuelRepository repository;
	
	public List<Duel> findAll(){
		return repository.findAll();
	}
	
	public Duel findById(Long id) {
		Optional<Duel> obj = repository.findById(id);
		return obj.get();
	}

}
