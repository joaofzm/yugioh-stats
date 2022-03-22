package br.com.joaofzm15.yugiohstats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joaofzm15.yugiohstats.entitites.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

	//No need to instantiate methods, they're inherited from JpaRepository
}
