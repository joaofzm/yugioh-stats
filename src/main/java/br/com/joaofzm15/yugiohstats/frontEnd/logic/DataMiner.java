package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;

public class DataMiner {

	
	// ===============Final Info Methods=========================================
	public static int getUserTotalWins() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(allDuels);
		return onlyWins.size();
	}
	public static int getUserTotalLosses() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(allDuels);
		return onlyLosses.size();
	}
	public static double getUserTotalWinRate() {
		int wins = getUserTotalWins();
		int losses = getUserTotalLosses();
		return Calculator.calculateWinRate(wins, losses);
	}

	
	
	
	
	public static int getUserTotalWinsGoingFirst() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(allDuels);
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(onlyFirst);
		return onlyWins.size();
	}
	public static int getUserTotalLossesGoingFirst() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(allDuels);
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(onlyFirst);
		return onlyLosses.size();
	}
	public static double getUserTotalWinRateGoingFirst() {
		int wins = getUserTotalWinsGoingFirst();
		int losses = getUserTotalLossesGoingFirst();
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getUserTotalWinsGoingSecond() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(allDuels);
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(onlySecond);
		return onlyWins.size();
	}
	public static int getUserTotalLossesGoingSecond() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(allDuels);
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(onlySecond);
		return onlyLosses.size();
	}
	public static double getUserTotalWinRateGoingSecond() {
		int wins = getUserTotalWinsGoingSecond();
		int losses = getUserTotalLossesGoingSecond();
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getUserTotalCoinWins() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyCoinWins = DuelListFilter.filterOnlyWonCoin(allDuels);
		return onlyCoinWins.size();
	}
	public static int getUserTotalCoinLosses() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyCoinLosses = DuelListFilter.filterOnlyLostCoin(allDuels);
		return onlyCoinLosses.size();
	}
	public static double getUserTotalCoinWinRate() {
		int wins = getUserTotalCoinWins();
		int losses = getUserTotalCoinLosses();
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getUserTotalDuelsGoingFirst() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(allDuels);
		return onlyFirst.size();
	}
	public static int getUserTotalDuelsGoingSecond() {
		List<Duel> allDuels = FrontEndInMemoryData.getAllDuelsFromUser();
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(allDuels);
		return onlySecond.size();
	}
	public static double getUserTotalGoingFirstFrequencyPercentage() {
			int first = getUserTotalDuelsGoingFirst();
			int second = getUserTotalDuelsGoingSecond();
			return Calculator.calculateWinRate(first, second);
	}
	
	
	// ===============Final Info Methods=========================================

}
