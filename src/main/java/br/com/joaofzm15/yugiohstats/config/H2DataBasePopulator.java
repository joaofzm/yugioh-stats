package br.com.joaofzm15.yugiohstats.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.repositories.PlayerRepository;

@Configuration
@Profile("h2TestProfile")
public class H2DataBasePopulator implements CommandLineRunner {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {
		Player revolver = new Player(null, "Revolver");
		Player irvin = new Player(null, "irvin");
		
		playerRepository.saveAll(Arrays.asList(revolver,irvin));
	}
}
