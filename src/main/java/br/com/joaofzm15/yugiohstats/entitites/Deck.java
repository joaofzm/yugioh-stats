package br.com.joaofzm15.yugiohstats.entitites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Deck implements Serializable {
	private static final long serialVersionUID = 575045973018717512L;
	
	private Long id;
	
	private String name;
	
	private Player player;
	
	private List<Duel> duels;
	
	public Deck() {
		duels = new ArrayList<>();
	}

	public Deck(Long id, String name, Player player) {
		this.id = id;
		this.name = name;
		this.player=player;
		duels = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Duel> getDuels() {
		return duels;
	}

	public void setDuels(List<Duel> duels) {
		this.duels = duels;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
		Deck other = (Deck) obj;
		return Objects.equals(id, other.id);
	}

	
	

}
