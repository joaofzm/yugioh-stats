package br.com.joaofzm15.yugiohstats.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.repositories.PlayerRepository;

@Component
public class InMemoryData {
	
	public Player currentlyLoggedPlayer = null;
	
	@Autowired
	private static PlayerRepository playerRepository;
	
	public Player playerLogIn(Player p) {
		List<Player> list;
		list = playerRepository.findAll();
		for (Player player : list) {
			if (player.getName().equals(p.getName())) {
				currentlyLoggedPlayer=p;
				return currentlyLoggedPlayer;
			}
		}
		return null;
	}
	
	public void playerLogOut() {
		currentlyLoggedPlayer=null;
	}

}
