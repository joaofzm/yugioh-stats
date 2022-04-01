package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;

public class DataMiner {

	
	// ===============Final Info Methods=========================================
	
	public static int getTotalWins(List<Duel> list) {
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(list);
		return onlyWins.size();
	}
	public static int getTotalLosses(List<Duel> list) {
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(list);
		return onlyLosses.size();
	}
	public static double getTotalWinRate(List<Duel> list) {
		int wins = getTotalWins(list);
		int losses = getTotalLosses(list);
		return Calculator.calculateWinRate(wins, losses);
	}

	
	
	
	
	public static int getTotalWinsGoingFirst(List<Duel> list) {
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(list);
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(onlyFirst);
		return onlyWins.size();
	}
	public static int getTotalLossesGoingFirst(List<Duel> list) {
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(list);
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(onlyFirst);
		return onlyLosses.size();
	}
	public static double getTotalWinRateGoingFirst(List<Duel> list) {
		int wins = getTotalWinsGoingFirst(list);
		int losses = getTotalLossesGoingFirst(list);
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getTotalWinsGoingSecond(List<Duel> list) {
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(list);
		List<Duel> onlyWins = DuelListFilter.filterOnlyWins(onlySecond);
		return onlyWins.size();
	}
	public static int getTotalLossesGoingSecond(List<Duel> list) {
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(list);
		List<Duel> onlyLosses = DuelListFilter.filterOnlyLosses(onlySecond);
		return onlyLosses.size();
	}
	public static double getTotalWinRateGoingSecond(List<Duel> list) {
		int wins = getTotalWinsGoingSecond(list);
		int losses = getTotalLossesGoingSecond(list);
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getTotalCoinWins(List<Duel> list) {
		List<Duel> onlyCoinWins = DuelListFilter.filterOnlyWonCoin(list);
		return onlyCoinWins.size();
	}
	public static int getTotalCoinLosses(List<Duel> list) {
		List<Duel> onlyCoinLosses = DuelListFilter.filterOnlyLostCoin(list);
		return onlyCoinLosses.size();
	}
	public static double getTotalCoinWinRate(List<Duel> list) {
		int wins = getTotalCoinWins(list);
		int losses = getTotalCoinLosses(list);
		return Calculator.calculateWinRate(wins, losses);
	}
	
	
	
	
	
	public static int getTotalDuelsGoingFirst(List<Duel> list) {
		List<Duel> onlyFirst = DuelListFilter.filterOnlyWentFirst(list);
		return onlyFirst.size();
	}
	public static int getTotalDuelsGoingSecond(List<Duel> list) {
		List<Duel> onlySecond = DuelListFilter.filterOnlyWentSecond(list);
		return onlySecond.size();
	}
	public static double getTotalGoingFirstFrequencyPercentage(List<Duel> list) {
			int first = getTotalDuelsGoingFirst(list);
			int second = getTotalDuelsGoingSecond(list);
			return Calculator.calculateWinRate(first, second);
	}
	
	
	// ===============Final Info Methods=========================================

}
