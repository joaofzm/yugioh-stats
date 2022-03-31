package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;

public class Calculator {

	public static double calculateWinRate(int wins, int losses) {
		double totalDuels = wins+losses;
		double oneHundredDividedByTotal = 100 / totalDuels;
		double toBeReturned = wins * oneHundredDividedByTotal;
		return toBeReturned;
	}
	
}
