package br.com.joaofzm15.yugiohstats;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Frame;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.LoginPanel;

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

	}

}
