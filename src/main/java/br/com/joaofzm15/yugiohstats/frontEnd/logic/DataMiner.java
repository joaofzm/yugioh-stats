package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;

public class DataMiner {

	// ===============Support Methods=========================================
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

	public static List<Duel> filterOnlyWinsFromListOfDuel(List<Duel> list){
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if(duel.isResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	
	public static List<Duel> filterOnlyLossesFromListOfDuel(List<Duel> list){
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if(!duel.isResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}

	public static List<Duel> filterOnlyDuelsWherePlayerWonCoin(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (duel.isCoinResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	
	public static List<Duel> filterOnlyDuelsWherePlayerLostCoin(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (!duel.isCoinResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	
	public static List<Duel> filterOnlyDuelsWherePlayerWentFirst(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (duel.isFirst()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	
	public static List<Duel> filterOnlyDuelsWherePlayerWentSecond(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (!duel.isFirst()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	// ===============Support Methods=========================================

	
	
	
	// ===============Final Info Methods=========================================
	public static int getUserTotalWins() {
		List<Duel> duels = getAllDuels();
		return getWinsFromList(duels);
	}
	public static int getUserTotalLosses() {
		List<Duel> duels = getAllDuels();
		return getLossesFromList(duels);
	}
	public static double getUserTotalWinRate() {
		double winRate = Calculator.calculateWinRate(getUserTotalWins(), getUserTotalLosses());
		return winRate;
	}

	
	public static int getUserTotalCoinWins() {
		List<Duel> duels = getAllDuels();
		return getCoinWinsFromList(duels);
	}
	public static int getUserTotalCoinLosses() {
		List<Duel> duels = getAllDuels();
		return getCoinLossesFromList(duels);
	}
	public static double getUserTotalCoinWinRate() {
		double winRate = Calculator.calculateWinRate(getUserTotalCoinWins(), getUserTotalCoinLosses());
		return winRate;
	}
	
	
	public static int getTotalWinsGoingFirst() {
		//TODO
		return 0;
	}
	public static int getTotalLossesGoingFirst() {
		//TODO
		return 0;
	}
	public static double getUserWinRateGoingFirst() {
		List<Duel> duels = filterOnlyDuelsWherePlayerWentFirst(getAllDuels());
		double winRate = Calculator.calculateWinRate(getWinsFromList(duels), getLossesFromList(duels));
		return winRate;
	}
	
	public static int getTotalWinsGoingSecond() {
		//TODO
		return 0;
	}
	public static int getTotalLossesGoingSecond() {
		//TODO
		return 0;
	}
	public static double getUserWinRateGoingSecond() {
		//TODO
		return 0;
	}
	// ===============Final Info Methods=========================================

}
