package br.com.joaofzm15.yugiohstats.frontEnd.logic;

import java.util.ArrayList;
import java.util.List;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;

public class DuelListFilter {
	
	public static List<Duel> filterOnlyWins(List<Duel> list){
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if(duel.isResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	public static List<Duel> filterOnlyLosses(List<Duel> list){
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if(!duel.isResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}

	public static List<Duel> filterOnlyWonCoin(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (duel.isCoinResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	public static List<Duel> filterOnlyLostCoin(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (!duel.isCoinResult()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	
	public static List<Duel> filterOnlyWentFirst(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (duel.isFirst()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
	public static List<Duel> filterOnlyWentSecond(List<Duel> list) {
		List<Duel> toBeReturned = new ArrayList<>();
		for (Duel duel : list) {
			if (!duel.isFirst()) {
				toBeReturned.add(duel);
			}
		}
		return toBeReturned;
	}
}
