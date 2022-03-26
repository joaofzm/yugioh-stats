package br.com.joaofzm15.yugiohstats.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.joaofzm15.yugiohstats.entitites.Deck;
import br.com.joaofzm15.yugiohstats.entitites.Duel;
import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.repositories.DeckRepository;
import br.com.joaofzm15.yugiohstats.repositories.DuelRepository;
import br.com.joaofzm15.yugiohstats.repositories.PlayerRepository;

@Configuration
@Profile("h2TestProfile")
public class H2DataBasePopulator implements CommandLineRunner {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private DeckRepository deckRepository;
	
	@Autowired
	private DuelRepository duelRepository;
	

	@Override
	public void run(String... args) throws Exception {
		Player p1 = new Player(null, "irvin");
		Player p2 = new Player(null, "Revolver");
		
		Deck d1 = new Deck(null, "Sky Striker", p1);
		Deck d2 = new Deck(null, "Dragon Link", p2);
		Deck d3 = new Deck(null, "Eldlitch", p1);
		
		Duel duel1 = new Duel(null,d1, false, false, true, OppDeck.DRYTRON, 2, Instant.parse("2020-07-23T16:22:12Z"));
		Duel duel2 = new Duel(null,d2, false, false, true, OppDeck.ALTERGEIST, 8, Instant.parse("2020-07-24T15:21:22Z"));
		Duel duel3 = new Duel(null,d3, false, false, true, OppDeck.ZOODIAC, 6, Instant.parse("2020-07-24T22:21:21Z"));
		Duel duel4 = new Duel(null,d1, false, false, true, OppDeck.ELDLICH, 1, Instant.parse("2020-07-26T03:15:56Z"));
		
		playerRepository.saveAll(Arrays.asList(p1,p2));
		deckRepository.saveAll(Arrays.asList(d1,d2,d3));
		duelRepository.saveAll(Arrays.asList(duel1,duel2,duel3,duel4));
	}
}
