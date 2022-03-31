package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;

public class ListInfoRetriever {
	
	public static int getWinsFromList(List<Duel> duels) {
		int wins = 0;
		for (Duel duel : duels) {
			if (duel.isResult()) {
				wins++;
			}
		}
		return wins;
	}
	
	public static int getLossesFromList(List<Duel> duels) {
		int losses = 0;
		for (Duel duel : duels) {
			if (!duel.isResult()) {
				losses++;
			}
		}
		return losses;
	}

	
	
	
	public static int getCoinWinsFromList(List<Duel> duels) {
		int wins = 0;
		for (Duel duel : duels) {
			if (duel.isCoinResult()) {
				wins++;
			}
		}
		return wins;
	}
	public static int getCoinLossesFromList(List<Duel> duels) {
		int losses = 0;
		for (Duel duel : duels) {
			if (!duel.isCoinResult()) {
				losses++;
			}
		}
		return losses;
	}

}
