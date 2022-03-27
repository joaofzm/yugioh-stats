package br.com.joaofzm15.yugiohstats.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.repositories.PlayerRepository;

public class InMemoryData {

	public static Player currentlyLoggedPlayer = null;

	public static Player playerLogIn(Player p) {
		currentlyLoggedPlayer = p;
		return p;
	}

	public static void playerLogOut() {
		currentlyLoggedPlayer = null;
	}

}
