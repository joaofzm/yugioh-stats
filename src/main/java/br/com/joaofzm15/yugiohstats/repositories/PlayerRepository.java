package br.com.joaofzm15.yugiohstats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaofzm15.yugiohstats.entitites.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	//No need to instantiate methods, they're inherited from JpaRepository
}
