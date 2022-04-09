package br.com.joaofzm15.yugiohstats.backEnd.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Player;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.backEnd.repositories.DeckRepository;
import br.com.joaofzm15.yugiohstats.backEnd.repositories.DuelRepository;
import br.com.joaofzm15.yugiohstats.backEnd.repositories.PlayerRepository;

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
		Player p1 = new Player(null, "irvin", "1234");
		Player p2 = new Player(null, "Revolver", "borreload");
		
		Deck d1 = new Deck(null, "Sky Striker", p1);
		Deck d2 = new Deck(null, "Dragon Link", p2);
		Deck d3 = new Deck(null, "Eldlitch", p1);

		Duel duel3 = new Duel(null, d1, false, true, false, OppDeck.Drytron, 2, Instant.parse("2020-07-23T16:22:12Z"));
	
		Duel duel1 = new Duel(null, d2, false, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-01-24T15:21:22Z"));
		Duel duel2 = new Duel(null, d3, false, false, true, OppDeck.Dinos, 0, Instant.parse("2022-01-24T22:21:21Z"));
		Duel duel4 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-01-26T03:15:56Z"));
		Duel duel5 = new Duel(null, d1, false, false, false, OppDeck.Thunder_dragon, 1, Instant.parse("2022-02-26T03:15:56Z"));
		Duel duel6 = new Duel(null, d1, true, false, true, OppDeck.Traptrix, 8, Instant.parse("2022-02-26T03:15:56Z"));
		Duel duel7 = new Duel(null, d1, false, false, true, OppDeck.Dinos, 4, Instant.parse("2022-03-08T03:15:56Z"));
		Duel duel8 = new Duel(null, d1, true, true, false, OppDeck.Numeron, 6, Instant.parse("2022-03-08T03:15:56Z"));
		Duel duel9 = new Duel(null, d1, false, true, true, OppDeck.Zoodiac_tri_brigade, 1, Instant.parse("2022-03-08T03:15:56Z"));
		Duel duel10 = new Duel(null, d1, true, true, false, OppDeck.Drytron, 8, Instant.parse("2022-03-26T03:15:56Z"));
		Duel duel11 = new Duel(null, d1, true, true, false, OppDeck.Dinos, 4, Instant.parse("2022-03-26T03:15:56Z"));
		Duel duel12 = new Duel(null, d1, true, false, true, OppDeck.Eldlich, 5, Instant.parse("2022-03-26T03:15:56Z"));
		Duel duel13 = new Duel(null, d1, false, true, true, OppDeck.Zoodiac_tri_brigade, 1, Instant.parse("2022-04-26T03:15:56Z"));
		Duel duel14 = new Duel(null, d1, true, true, false, OppDeck.Adamancipator, 2, Instant.parse("2022-04-26T03:15:56Z"));
		Duel duel15 = new Duel(null, d1, false, false, true, OppDeck.Code_talker, 8, Instant.parse("2022-05-26T03:15:56Z"));
		Duel duel16 = new Duel(null, d1, true, true, true, OppDeck.Adamancipator, 9, Instant.parse("2022-07-26T03:15:56Z"));
		Duel duel17 = new Duel(null, d1, true, false, true, OppDeck.Dragonmaid, 16, Instant.parse("2022-07-26T03:15:56Z"));
		Duel duel18 = new Duel(null, d1, true, false, true, OppDeck.Numeron, 3, Instant.parse("2022-08-26T03:15:56Z"));
		
		Duel duel19 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel20 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel21 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel22 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel23 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel24 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel25 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel26 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));
		Duel duel27 = new Duel(null, d1, true, false, true, OppDeck.Altergeist, 0, Instant.parse("2022-10-26T03:15:56Z"));


		playerRepository.saveAll(Arrays.asList(p1, p2));
		deckRepository.saveAll(Arrays.asList(d1, d2, d3));
		duelRepository.saveAll(Arrays.asList(duel1, duel2, duel3, duel4,
				duel5, duel6, duel7, duel8, duel9, duel10, duel11,duel12,
				duel13,duel14,duel15,duel16,duel17,duel18,duel19,duel20,duel21,duel22,duel23
				,duel24,duel25,duel26,duel27));
	}
}
