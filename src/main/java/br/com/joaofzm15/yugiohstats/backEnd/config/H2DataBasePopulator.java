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

		Duel duel1 = new Duel(null, d2, false, false, true, OppDeck.ALTERGEIST, 8, Instant.parse("2020-07-24T15:21:22Z"));
		Duel duel2 = new Duel(null, d3, false, false, true, OppDeck.ZOODIAC, 6, Instant.parse("2020-07-24T22:21:21Z"));
		
		Duel duel3 = new Duel(null, d1, false, true, false, OppDeck.DRYTRON, 2, Instant.parse("2020-07-23T16:22:12Z"));
		Duel duel4 = new Duel(null, d1, true, false, true, OppDeck.ALTERGEIST, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel5 = new Duel(null, d1, false, false, false, OppDeck.DANGER, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel6 = new Duel(null, d1, true, false, true, OppDeck.DARKLORD, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel7 = new Duel(null, d1, false, false, true, OppDeck.DINOS, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel8 = new Duel(null, d1, true, true, false, OppDeck.NUMERON, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel9 = new Duel(null, d1, false, true, true, OppDeck.ZOODIAC_TRI_BRIGADE, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel10 = new Duel(null, d1, true, true, false, OppDeck.DRYTRON, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel11 = new Duel(null, d1, true, true, false, OppDeck.DINOS, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel12 = new Duel(null, d1, true, false, true, OppDeck.ELDLICH, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel13 = new Duel(null, d1, false, true, true, OppDeck.ZOODIAC_TRI_BRIGADE, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel14 = new Duel(null, d1, true, true, false, OppDeck.ADAMANCIPATOR, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel15 = new Duel(null, d1, false, false, true, OppDeck.CODE_TALKER, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel16 = new Duel(null, d1, true, true, true, OppDeck.ADAMANCIPATOR, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel17 = new Duel(null, d1, true, false, true, OppDeck.DRAGONMAID, 1, Instant.parse("2020-07-26T03:15:56Z"));
		Duel duel18 = new Duel(null, d1, true, false, true, OppDeck.NUMERON, 1, Instant.parse("2020-07-26T03:15:56Z"));

		playerRepository.saveAll(Arrays.asList(p1, p2));
		deckRepository.saveAll(Arrays.asList(d1, d2, d3));
		duelRepository.saveAll(Arrays.asList(duel1, duel2, duel3, duel4,
				duel5, duel6, duel7, duel8, duel9, duel10, duel11,duel12,
				duel13,duel14,duel15,duel16,duel17,duel18));
	}
}
