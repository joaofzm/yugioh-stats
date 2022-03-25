package br.com.joaofzm15.yugiohstats;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.joaofzm15.yugiohstats.gui.components.Frame;
import br.com.joaofzm15.yugiohstats.gui.config.Config;
import br.com.joaofzm15.yugiohstats.gui.panels.MenuPanel;

@SpringBootApplication
public class YugiohStatsApplication {

	public static void main(String[] args) {
		
		Config.setMultiplier();
		Frame frame = new Frame(Config.x, Config.y);
		MenuPanel initialPanel = new MenuPanel(frame.getJFrame());
		frame.getJFrame().getContentPane().removeAll();
		frame.getJFrame().getContentPane().add(initialPanel.getPanel().getJComponent());
		frame.getJFrame().revalidate();
		initialPanel.getPanel().getJComponent().repaint();
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(YugiohStatsApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);

		

		
	}

}
