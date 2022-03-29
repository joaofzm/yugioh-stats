package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.frontEnd.exceptions.BlankFieldException;
import br.com.joaofzm15.yugiohstats.frontEnd.exceptions.TextFieldInputMismatchException;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.CheckBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.ComboBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.http.HttpController;

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
	
	private Button returnButton;
	

	private JFrame frame;
	
	public AddDuelPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		deckComboBox = new ComboBox(120, 455, 300, 100, "x", 255, 255, 255, 50, 120, 50, 28);

		List<Deck> decksList = FrontEndInMemoryData.currentlyLoggedPlayer.getDecks();
		deckComboBox.getJComponent().setModel(new DefaultComboBoxModel(decksList.toArray()));
	
		panel.add(deckComboBox);
		
		
		duelWBox = new CheckBox(570, 400, 100, 100, "W", 255, 255, 255, 50,255,50, 50);
		duelWBox.getJComponent().addActionListener(this);
		panel.add(duelWBox);
		duelLBox = new CheckBox(570, 510, 100, 100, "L", 255, 255, 255, 255,50,50, 50);
		duelLBox.getJComponent().addActionListener(this);
		panel.add(duelLBox);
		
		
		coinWBox = new CheckBox(830, 400, 100, 100, "W", 255, 255, 255, 200,200,50, 50);
		coinWBox.getJComponent().addActionListener(this);
		panel.add(coinWBox);
		coinLBox = new CheckBox(830, 510, 100, 100, "L", 255, 255, 255, 50,50,50, 50);
		coinLBox.getJComponent().addActionListener(this);
		panel.add(coinLBox);
		
		firstBox = new CheckBox(940, 400, 100, 100, "1st", 255, 255, 255, 200,200,50, 40);
		firstBox.getJComponent().addActionListener(this);
		panel.add(firstBox);
		secondBox = new CheckBox(940, 510, 100, 100, "2nd", 255, 255, 255, 50,50,50, 40);
		secondBox.getJComponent().addActionListener(this);
		panel.add(secondBox);
		
		turnsTextField = new TextField(1200, 455, 100, 100, " turns", 40);
		panel.add(turnsTextField);
		
		oppDecKComboBox = new ComboBox(1460, 455, 300, 100, "x", 255, 255, 255, 120, 50, 50, 28);
		OppDeck[] items = OppDeck.values();
		oppDecKComboBox.getJComponent().setModel(new DefaultComboBoxModel(items));
		panel.add(oppDecKComboBox);
		
		addDuelButton = new Button(900, 720, 120, 56, "ADD", 50, 255, 50, 70);
		addDuelButton.getJComponent().addActionListener(this);
		panel.add(addDuelButton);

		returnButton = new Button(865, 950, 190, 56, "RETURN",255,20,20,62);
		returnButton.getJComponent().addActionListener(this);
		panel.add(returnButton);
		
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

	public boolean getInputFromTwoBoxes(CheckBox trueOutcome, CheckBox falseOutcome) {
		if (trueOutcome.getJComponent().isSelected()) {
			return true;
		} else if (falseOutcome.getJComponent().isSelected()) {
			return false;
		} else {
			throw new BlankFieldException("Please pick an option in all fields!");
		}
	}
	
	public String getTurnsAndValidadeIt() {
		Integer turnsParsedToInt = 0;
		try {
			turnsParsedToInt = Integer.valueOf(turnsTextField.getJComponent().getText());
		} catch (NumberFormatException e) {
			throw new TextFieldInputMismatchException("Input doesn't match requirements!");
		}
		
		if (turnsParsedToInt!=0) {
			return String.valueOf(turnsParsedToInt);
		} else {
			throw new BlankFieldException("Please pick an option in all fields!");
		}
	}
	
//	public boolean
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== duelWBox.getJComponent()) {
			if (duelLBox.getJComponent().isSelected()) {
				duelLBox.getJComponent().setSelected(false);
			} 
		}
		if (e.getSource()== duelLBox.getJComponent()) {
			if (duelWBox.getJComponent().isSelected()) {
				duelWBox.getJComponent().setSelected(false);
			} 
		}
		if (e.getSource()== coinWBox.getJComponent()) {
			if (coinLBox.getJComponent().isSelected()) {
				coinLBox.getJComponent().setSelected(false);
			} 
		}
		if (e.getSource()== coinLBox.getJComponent()) {
			if (coinWBox.getJComponent().isSelected()) {
				coinWBox.getJComponent().setSelected(false);
			} 
		}
		if (e.getSource()== firstBox.getJComponent()) {
			if (secondBox.getJComponent().isSelected()) {
				secondBox.getJComponent().setSelected(false);
			} 
		}
		if (e.getSource()== secondBox.getJComponent()) {
			if (firstBox.getJComponent().isSelected()) {
				firstBox.getJComponent().setSelected(false);
			} 
		}
		
		
		if (e.getSource() == addDuelButton.getJComponent()) {
			try {
				HttpController.post("{"
						+ "        \"coinResult\": "+ getInputFromTwoBoxes(coinWBox, coinLBox) +","
						+ "        \"first\":" + getInputFromTwoBoxes(firstBox, secondBox) +","
						+ "        \"result\": " + getInputFromTwoBoxes(duelWBox, duelLBox) +","
						+ "        \"turns\": " + getTurnsAndValidadeIt() + ","
						+ "        \"deck\":{"
						+ "            \"id\":1"
						+ "        },"
						+ "        \"oppDeck\": 16"
						+ "    }"
						,"http://localhost:8080/duels");
				JOptionPane.showMessageDialog(null, "Duel added sucesfully!!");
			} catch (BlankFieldException e1) {
				JOptionPane.showMessageDialog(null, "ERROR! Please fill in all fields!");
			} catch (TextFieldInputMismatchException e2) {
				JOptionPane.showMessageDialog(null, "ERROR! Turns must be a number!");
			}
		}
		
		if (e.getSource() == returnButton.getJComponent()) {
			MenuPanel initialPanel = new MenuPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
	}

}