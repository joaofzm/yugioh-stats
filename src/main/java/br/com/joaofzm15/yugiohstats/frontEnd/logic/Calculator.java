package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;

public class Calculator {

	public static double calculateWinRate(int wins, int losses) {
		int totalDuels = wins+losses;
		double oneHundredDividedByTotal = 100 / totalDuels;
		double toBeReturned = wins * oneHundredDividedByTotal;
		return toBeReturned;
	}
	
	public static double calculateUserTotalWinRate() {
		List<Duel> duels = DataMiner.getAllDuels();
		double winRate = calculateWinRate(DataMiner.getWinsFromList(duels),DataMiner.getLossesFromList(duels));
		return winRate;
	}
	
}
