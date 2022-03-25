package br.com.joaofzm15.yugiohstats.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.yugiohstats.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.gui.components.Button;
import br.com.joaofzm15.yugiohstats.gui.components.CheckBox;
import br.com.joaofzm15.yugiohstats.gui.components.ComboBox;
import br.com.joaofzm15.yugiohstats.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.gui.config.Config;

public class AddDuelPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	
	private ComboBox deckComboBox;
	
	private CheckBox duelWBox;
	private CheckBox duelLBox;
	
	private CheckBox coinWBox;
	private CheckBox coinLBox;
	
	private CheckBox firstBox;
	private CheckBox secondBox;
	
	private TextField turnsTextField;
	
	private ComboBox oppDecKComboBox;
	
	private Button addDuelButton;
	
	private Button exitButton;
	

	private JFrame frame;
	
	public AddDuelPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		deckComboBox = new ComboBox(120, 455, 300, 100, "x", 255, 255, 255, 50, 120, 50, 28);
		OppDeck[] items2 = OppDeck.values();
		deckComboBox.getJComponent().setModel(new DefaultComboBoxModel(items2));
		panel.add(deckComboBox);
		
		duelWBox = new CheckBox(570, 400, 100, 100, "W", 255, 255, 255, 50,255,50, 50);
		panel.add(duelWBox);
		duelLBox = new CheckBox(570, 510, 100, 100, "L", 255, 255, 255, 255,50,50, 50);
		panel.add(duelLBox);
		
		coinWBox = new CheckBox(830, 400, 100, 100, "W", 255, 255, 255, 200,200,50, 50);
		panel.add(coinWBox);
		coinLBox = new CheckBox(830, 510, 100, 100, "L", 255, 255, 255, 50,50,50, 50);
		panel.add(coinLBox);
		
		firstBox = new CheckBox(940, 400, 100, 100, "1st", 255, 255, 255, 200,200,50, 40);
		panel.add(firstBox);
		secondBox = new CheckBox(940, 510, 100, 100, "2nd", 255, 255, 255, 50,50,50, 40);
		panel.add(secondBox);
		
		turnsTextField = new TextField(1200, 455, 100, 100, "    turns");
		panel.add(turnsTextField);
		
		oppDecKComboBox = new ComboBox(1460, 455, 300, 100, "x", 255, 255, 255, 120, 50, 50, 28);
		OppDeck[] items = OppDeck.values();
		oppDecKComboBox.getJComponent().setModel(new DefaultComboBoxModel(items));
		panel.add(oppDecKComboBox);
		
		addDuelButton = new Button(900, 720, 120, 56, "ADD", 50, 255, 50, 70);
		addDuelButton.getJComponent().addActionListener(this);
		panel.add(addDuelButton);

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
		
		if (e.getSource() == addDuelButton.getJComponent()) {
			System.out.println("add");
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