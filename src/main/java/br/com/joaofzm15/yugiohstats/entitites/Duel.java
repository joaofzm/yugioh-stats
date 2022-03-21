package br.com.joaofzm15.yugiohstats.entitites;

import java.io.Serializable;
import java.util.Objects;

import br.com.joaofzm15.yugiohstats.entitites.enums.OppDeck;

public class Duel implements Serializable {
	private static final long serialVersionUID = 8062344200862253875L;

	private Long id;
	private boolean coinResult;
	private boolean result;
	private Deck deck;
	private OppDeck oppDeck;
	private int turns;

	public Duel() {

	}

	public Duel(Long id, boolean coinResult, boolean result, Deck deck, OppDeck oppDeck, int turns) {
		this.id = id;
		this.coinResult = coinResult;
		this.result = result;
		this.deck = deck;
		this.oppDeck = oppDeck;
		this.turns = turns;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCoinResult() {
		return coinResult;
	}

	public void setCoinResult(boolean coinResult) {
		this.coinResult = coinResult;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public OppDeck getOppDeck() {
		return oppDeck;
	}

	public void setOppDeck(OppDeck oppDeck) {
		this.oppDeck = oppDeck;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Duel other = (Duel) obj;
		return Objects.equals(id, other.id);
	}

}
