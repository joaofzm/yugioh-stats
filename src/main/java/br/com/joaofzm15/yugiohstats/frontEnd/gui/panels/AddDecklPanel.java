package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;import org.springframework.web.HttpMediaTypeException;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Player;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.http.HttpController;

public class AddDecklPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	
	private TextField deckNameTextField;
	
	private Button addDeckButton;
	
	private Button exitButton;
	

	private JFrame frame;
	
	public AddDecklPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		
		deckNameTextField = new TextField(810, 560, 280, 80, "DECK NAME",28);
		panel.add(deckNameTextField);
		
		addDeckButton = new Button(900, 720, 120, 56, "ADD", 50, 255, 50, 70);
		addDeckButton.getJComponent().addActionListener(this);
		panel.add(addDeckButton);

		exitButton = new Button(865, 950, 190, 56, "RETURN",255,20,20,62);
		exitButton.getJComponent().addActionListener(this);
		panel.add(exitButton);
		
		bg = new JLabel();
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/bg1280x720.png"));
		bg.setSize(1920,1080);
		if (Config.res==2) {
			icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/bg1280x720.png"));
			bg.setSize(1280,720);
		}
		bg.setIcon(icon);
		panel.getJComponent().add(bg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addDeckButton.getJComponent()) {
			if (deckNameTextField.getJComponent().getText().equals("DECK NAME")) {
				JOptionPane.showMessageDialog(null, "ERROR! Please type the deck name!");
			} else {
				HttpController.post("{\"name\": \" " + deckNameTextField.getJComponent().getText() + " \",\"player\":{\"id\":"+ FrontEndInMemoryData.currentlyLoggedPlayer.getId() +"}}"
						,"http://localhost:8080/decks");
				JOptionPane.showMessageDialog(null, "Deck added sucesfully!");
				FrontEndInMemoryData.updateLoggedPlayerData();
			}
		}
		
		if (e.getSource() == exitButton.getJComponent()) {
			MenuPanel initialPanel = new MenuPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
	}

}