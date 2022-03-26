package br.com.joaofzm15.yugiohstats;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.joaofzm15.yugiohstats.config.InMemoryData;
import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.gui.components.Frame;
import br.com.joaofzm15.yugiohstats.gui.config.Config;
import br.com.joaofzm15.yugiohstats.gui.panels.LoginPanel;
import br.com.joaofzm15.yugiohstats.gui.panels.MenuPanel;

@SpringBootApplication
public class YugiohStatsApplication {

	public static void main(String[] args) {
		
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YugiohStatsApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
		
		Config.setMultiplier();
		Frame frame = new Frame(Config.x, Config.y);
		LoginPanel initialPanel = new LoginPanel(frame.getJFrame());
		frame.getJFrame().getContentPane().removeAll();
		frame.getJFrame().getContentPane().add(initialPanel.getPanel().getJComponent());
		frame.getJFrame().revalidate();
		initialPanel.getPanel().getJComponent().repaint();

		Player p = new Player();
		InMemoryData imd = new InMemoryData();
		imd.playerLogIn(p);
		

		
	}

}
