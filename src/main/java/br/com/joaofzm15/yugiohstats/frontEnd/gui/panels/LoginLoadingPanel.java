package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Label;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;

public class LoginLoadingPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private Label loadingLabel;
	
	private JFrame frame;
	
	public LoginLoadingPanel(JFrame frame) {
		
		this.frame=frame;
		panel = new Panel(1920,1080);
		
		loadingLabel= new Label(713, 400, 498,498, "Assets/loading.png");
		panel.add(loadingLabel);
		
		bg = new JLabel();
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/lockedmenubg1280x720.png"));
		bg.setSize(1920,1080);
		if (Config.res==2) {
			icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/lockedmenubg1280x720.png"));
			bg.setSize(1280,720);
		}
		
		bg.setIcon(icon);
		panel.getJComponent().add(bg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}