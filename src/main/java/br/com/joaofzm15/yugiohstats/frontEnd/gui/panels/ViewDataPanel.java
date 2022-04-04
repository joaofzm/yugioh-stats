package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.ComboBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Label;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DataMiner;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DuelListFilter;

public class ViewDataPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private Label titleLabel;

	private ComboBox deckComboBox;
	private Button viewDeckStatsButton;
	
	private ComboBox oppDeckComboBox;
	
	private Button returnButton;
	
	private Label winRateLabel;
	private Label goingFirstWinRateLabel;
	private Label goingSecondWinRateLabel;
	
	private Label coinWinRateLabel;
	private Label goingFirstFrequencyLabel;

	private JFrame frame;
	
	public ViewDataPanel(JFrame frame, List<Duel> parameterList, String title) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		titleLabel = new Label(0, 70, 1920, 130, title, 130, 200, 200, 255);
		panel.add(titleLabel);
		
		deckComboBox = new ComboBox(355, 785, 300, 100, "x", 255, 255, 255, 50, 120, 50, 28);
		List<Deck> decksList = FrontEndInMemoryData.currentlyLoggedPlayer.getDecks();
		List<Deck> copyOfDecksList = new ArrayList<>();
		for (Deck deck : decksList) {
			copyOfDecksList.add(deck);
		}
		copyOfDecksList.add(0,new Deck(null, "ALL DECKS", null));
		deckComboBox.getJComponent().setModel(new DefaultComboBoxModel(copyOfDecksList.toArray()));
		panel.add(deckComboBox);
		
		viewDeckStatsButton = new Button(690, 870, 190, 56, "FILTER",50,200,50,62);
		viewDeckStatsButton.getJComponent().addActionListener(this);
		panel.add(viewDeckStatsButton);
		
		oppDeckComboBox = new ComboBox(355, 915, 300, 100, "x", 255, 255, 255, 120, 50, 50, 28);
		OppDeck[] items = OppDeck.values();
		oppDeckComboBox.getJComponent().setModel(new DefaultComboBoxModel(items));
		panel.add(oppDeckComboBox);
		
		returnButton = new Button(1300, 870, 200, 56, "RETURN",255,20,20,62);
		returnButton.getJComponent().addActionListener(this);
		panel.add(returnButton);
		
		
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		//===============================================
		int labelY = 270;
		//===============================================
		int totalWins = DataMiner.getTotalWins(parameterList);
		int totalLosses = DataMiner.getTotalLosses(parameterList);
		int totalDuels = totalWins+totalLosses;
		double winrate = DataMiner.getTotalWinRate(parameterList);
		winRateLabel = new Label(0, labelY, 1920, 50, "Total  >>>  "
				+ "Wins: "+totalWins+"  "
				+ "|  Losses: "+totalLosses+"  "
				+ "|  ( "+totalDuels+" )  -  "+winrate+"%"
				, 50, 200, 200, 255);
		panel.add(winRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		int totalFirstWins = DataMiner.getTotalWinsGoingFirst(parameterList);
		int totalFirstLosses = DataMiner.getTotalLossesGoingFirst(parameterList);
		int totalFirstDuels = totalFirstWins+totalFirstLosses;
		double firstWinrate = DataMiner.getTotalWinRateGoingFirst(parameterList);
		goingFirstWinRateLabel = new Label(0, labelY, 1920, 50, "Going Fist  >>>  "
				+ "Wins: "+totalFirstWins+"  "
				+ "|  Losses: "+totalFirstLosses+"  "
				+ "|  ( "+totalFirstDuels+" )  -  "+firstWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingFirstWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalSecondWins = DataMiner.getTotalWinsGoingSecond(parameterList);
		int totalSecondLosses = DataMiner.getTotalLossesGoingSecond(parameterList);
		int totalSecondDuels = totalSecondWins+totalSecondLosses;
		double secondWinrate = DataMiner.getTotalWinRateGoingSecond(parameterList);
		goingSecondWinRateLabel = new Label(0, labelY, 1920, 50, "Going Second  >>>  "
				+ "Wins: "+totalSecondWins+"  "
				+ "|  Losses: "+totalSecondLosses+"  "
				+ "|  ( "+totalSecondDuels+" )  -  "+secondWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingSecondWinRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		int totalCoinWins = DataMiner.getTotalCoinWins(parameterList);
		int totalCoinLosses = DataMiner.getTotalCoinLosses(parameterList);
		int totalCoinsThrow = totalCoinWins+totalCoinLosses;
		double coinWinrate = DataMiner.getTotalCoinWinRate(parameterList);
		coinWinRateLabel = new Label(0, labelY, 1920, 50, "Coin toss win rate  >>>  "
				+ "Wins: "+totalCoinWins+"  "
				+ "|  Losses: "+totalCoinLosses+"  "
				+ "|  ( "+totalCoinsThrow+" )  -  "+coinWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(coinWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalDuelsGoingFirst = DataMiner.getTotalDuelsGoingFirst(parameterList);
		int totalDuelsGoingSecond = DataMiner.getTotalDuelsGoingSecond(parameterList);
		int totalDuelsAmount = totalDuelsGoingFirst+totalDuelsGoingSecond;
		double goingFirstFrequency = DataMiner.getTotalGoingFirstFrequencyPercentage(parameterList);
		goingFirstFrequencyLabel = new Label(0, labelY, 1920, 50, "Play first frequency  >>>  "
				+ "First: "+totalDuelsGoingFirst+"  "
				+ "|  Second: "+totalDuelsGoingSecond+"  "
				+ "|  ( "+totalDuelsAmount+" )  -  "+goingFirstFrequency+"%"
				, 50, 200, 200, 255);
		panel.add(goingFirstFrequencyLabel);
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
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

	private Deck getSelectedDeck() {
		String selectedDeckName = deckComboBox.getJComponent().getSelectedItem().toString();
		List<Deck> decksList = FrontEndInMemoryData.currentlyLoggedPlayer.getDecks();
		for (Deck deck : decksList) {
			if (deck.getName().equals(selectedDeckName)) {
				return deck;
			}
		}
		return null;
	}
	
	private OppDeck getSelectedOppDeck() {
		return (OppDeck) oppDeckComboBox.getJComponent().getSelectedItem();
	}
	
	//TODO
	private String formatOppDeckString(OppDeck oppDeck) {
		return oppDeck.toString();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == viewDeckStatsButton.getJComponent()) {
			
			List<Duel> allDuelsFromSelectedDeck ;
			ViewDataPanel initialPanel;
			
			if (deckComboBox.getJComponent().getSelectedItem().toString().equals("ALL DECKS")) {
				
				if (getSelectedOppDeck()!=OppDeck.ALL_DECKS) {
					allDuelsFromSelectedDeck=DuelListFilter.filterOnlyAgainst(
							FrontEndInMemoryData.getAllDuelsFromUser(),
							getSelectedOppDeck());
					initialPanel = new ViewDataPanel(frame,allDuelsFromSelectedDeck,
							"All decks  vs  "+formatOppDeckString(getSelectedOppDeck()));
				} else {
					allDuelsFromSelectedDeck=FrontEndInMemoryData.getAllDuelsFromUser();
					initialPanel = new ViewDataPanel(frame,allDuelsFromSelectedDeck,"All decks  vs  All decks");
				}
				
			
			} else {
				
				if (getSelectedOppDeck()!=OppDeck.ALL_DECKS) {
					allDuelsFromSelectedDeck=DuelListFilter.filterOnlyAgainst(
							getSelectedDeck().getDuels(),
							getSelectedOppDeck());
					initialPanel = new ViewDataPanel(frame
							,allDuelsFromSelectedDeck,getSelectedDeck().getName()+"  vs  "+formatOppDeckString(getSelectedOppDeck()));
				} else {
					allDuelsFromSelectedDeck=getSelectedDeck().getDuels();
					initialPanel = new ViewDataPanel(frame
							,allDuelsFromSelectedDeck, getSelectedDeck().getName()+"  vs  All Decks");
				}
		
			}
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
	
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