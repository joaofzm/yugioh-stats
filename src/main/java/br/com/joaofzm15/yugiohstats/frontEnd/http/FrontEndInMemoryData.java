package br.com.joaofzm15.yugiohstats.frontEnd.http;

import java.net.http.HttpResponse;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Player;

public class FrontEndInMemoryData {
	
	public static Player currentlyLoggedPlayer;
	
	public static Player logIn(String username) {
		HttpResponse<String> response = HttpController.getHttpResponseFromUrl("http://localhost:8080/players/");
		List<Player> list = HttpController.parseJsonIntoPlayer(response);
		
		for (Player player : list) {
			if (player.getName().equals(username)) {
				currentlyLoggedPlayer = player;
				return player;
			}
		}
		return null;
	}
	
	public static void updateLoggedPlayerData() {
		String name = currentlyLoggedPlayer.getName();
		logOut();
		logIn(name);
	}
	
	public static void logOut() {
		currentlyLoggedPlayer=null;
	}
	
	public static List<Deck> getDecks() {
		return null;
	}

}
