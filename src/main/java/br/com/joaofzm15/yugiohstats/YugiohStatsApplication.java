package br.com.joaofzm15.yugiohstats;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Frame;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.AddDecklPanel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.AddDuelPanel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.LoginLoadingPanel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.LoginPanel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.panels.RegisterAccountPanel;

@SpringBootApplication
public class YugiohStatsApplication {

	public static void main(String[] args) {
		
		Config.setMultiplier();
		Frame frame = new Frame(Config.x, Config.y);
		
		LoginLoadingPanel initialPanel = new LoginLoadingPanel(frame.getJFrame());
		frame.getJFrame().getContentPane().removeAll();
		frame.getJFrame().getContentPane().add(initialPanel.getPanel().getJComponent());
		frame.getJFrame().revalidate();
		initialPanel.getPanel().getJComponent().repaint();

		SpringApplicationBuilder builder = new SpringApplicationBuilder(YugiohStatsApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
		
		LoginPanel secondPanel = new LoginPanel(frame.getJFrame());
		frame.getJFrame().getContentPane().removeAll();
		frame.getJFrame().getContentPane().add(secondPanel.getPanel().getJComponent());
		frame.getJFrame().revalidate();
		secondPanel.getPanel().getJComponent().repaint();


	}

}
