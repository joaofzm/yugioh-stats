package br.com.joaofzm15.yugiohstats.backEnd.entitites;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.enums.OppDeck;

@Entity
public class Duel implements Serializable {
	private static final long serialVersionUID = 8062344200862253875L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "deck_id")
	private Deck deck;
	
	private boolean coinResult;
	private boolean first;
	private boolean result;
	private OppDeck oppDeck;
	private int turns;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
//	 @JsonSerialize(using = LocalDateTimeSerializer.class)
	private Instant moment;

	public Duel() {

	}

	public Duel(Long id, Deck deck, boolean coinResult, boolean first, boolean result, OppDeck oppDeck, int turns, Instant moment) {
		this.id = id;
		this.coinResult = coinResult;
		this.first=first;
		this.result = result;
		this.deck = deck;
		this.oppDeck = oppDeck;
		this.turns = turns;
		this.moment = moment;
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
	
	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant date) {
		this.moment = date;
	}
	
	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
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
