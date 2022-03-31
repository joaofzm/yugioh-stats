package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;

public class DataMiner {

	public static List<Duel> getAllDuels() {
		List<Duel> duels = new ArrayList<>();
		
		List<Deck> decks = FrontEndInMemoryData.currentlyLoggedPlayer.getDecks();
		for (Deck deck : decks) {
			List<Duel> deckDuels = deck.getDuels();
			for (Duel duel : deckDuels) {
				duels.add(duel);
			}
		}
		return duels;
	}
		
	public static int getWinsFromList(List<Duel> duels) {
		int wins = 0 ;
		for (Duel duel : duels) {
			if (duel.isResult()) {
				wins++;
			}
		}
		return wins;
	}
	
	public static int getLossesFromList(List<Duel> duels) {
		int losses = 0 ;
		for (Duel duel : duels) {
			if (!duel.isResult()) {
				losses++;
			}
		}
		return losses;
	}
	
}
