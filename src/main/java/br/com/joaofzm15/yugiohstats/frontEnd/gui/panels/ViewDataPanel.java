package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import br.com.joaofzm15.yugiohstats.frontEnd.logic.Calculator;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DataMiner;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DuelListFilter;

public class ViewDataPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private ComboBox seasonComboBox;
	private Button filterSeasonButton;

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
		
		List<Duel> listFilteredOnlySelectedSeason = DuelListFilter.filterOnlyFromSelectedSeason(parameterList);

		panel = new Panel(1920,1080);
		
		seasonComboBox = new ComboBox(35, 85, 300, 100, "x", 255, 255, 255, 50, 50, 120, 28);
		List<String> seasonComboBoxListOfItems = new ArrayList<>();
		seasonComboBoxListOfItems.add("All Seasons");
		for (int i=1; i<11; i++) {
			seasonComboBoxListOfItems.add("Season "+i);
		}
		seasonComboBox.getJComponent().setModel(new DefaultComboBoxModel(seasonComboBoxListOfItems.toArray()));
		seasonComboBox.getJComponent().setSelectedIndex(FrontEndInMemoryData.filteredSeason);
		panel.add(seasonComboBox);
		
		filterSeasonButton = new Button(85, 198, 180, 56, "FILTER",150,150,255,62);
		filterSeasonButton.getJComponent().addActionListener(this);
		panel.add(filterSeasonButton);
		
		titleLabel = new Label(100, 70, 1920, 130, title, 70, 200, 200, 255);
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
	    DecimalFormat df = new DecimalFormat("0.000");
		//===============================================
		int labelY = 270;
		//===============================================
		int totalWins = DataMiner.getTotalWins(listFilteredOnlySelectedSeason);
		int totalLosses = DataMiner.getTotalLosses(listFilteredOnlySelectedSeason);
		int totalDuels = totalWins+totalLosses;
		double winrate = DataMiner.getTotalWinRate(listFilteredOnlySelectedSeason);
		int totalTurnsFromDuelsWithTurnCount = DataMiner.getTotalTurnsFromDuelsWithTurnCount(listFilteredOnlySelectedSeason);
		int totalDuelsWithTurnCount = DataMiner.getAmountOfDuelsWithTurnCount(listFilteredOnlySelectedSeason);
		double avgTurns = Calculator.calculateAverage(totalTurnsFromDuelsWithTurnCount, totalDuelsWithTurnCount);
		winRateLabel = new Label(0, labelY, 1920, 50, "Total  >>>  "
				+ "Wins: "+totalWins+"  "
				+ "|  Losses: "+totalLosses+"  "
				+ "|  ( "+totalDuels+" )  -  "+df.format(winrate)+"%  "
				+ "|  Avg. Turns: "+df.format(avgTurns)
				, 50, 200, 200, 255);
		panel.add(winRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		List<Duel> duelsGoingFirst = DuelListFilter.filterOnlyWentFirst(listFilteredOnlySelectedSeason);
		int totalFirstWins = DataMiner.getTotalWinsGoingFirst(duelsGoingFirst);
		int totalFirstLosses = DataMiner.getTotalLossesGoingFirst(duelsGoingFirst);
		int totalFirstDuels = totalFirstWins+totalFirstLosses;
		double firstWinrate = DataMiner.getTotalWinRateGoingFirst(duelsGoingFirst);
		int totalTurnsFromDuelsWithTurnCountFirst = DataMiner.getTotalTurnsFromDuelsWithTurnCount(duelsGoingFirst);
		int totalDuelsWithTurnCountFirst = DataMiner.getAmountOfDuelsWithTurnCount(duelsGoingFirst);
		double avgTurnsFirst = Calculator.calculateAverage(totalTurnsFromDuelsWithTurnCountFirst, totalDuelsWithTurnCountFirst);
		
		goingFirstWinRateLabel = new Label(0, labelY, 1920, 50, "Going Fist  >>>  "
				+ "Wins: "+totalFirstWins+"  "
				+ "|  Losses: "+totalFirstLosses+"  "
				+ "|  ( "+totalFirstDuels+" )  -  "+df.format(firstWinrate)+"%  "
				+ "|  Avg. Turns: "+df.format(avgTurnsFirst)

				, 50, 200, 200, 255);
		panel.add(goingFirstWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		List<Duel> duelsGoingSecond = DuelListFilter.filterOnlyWentSecond(listFilteredOnlySelectedSeason);
		int totalSecondWins = DataMiner.getTotalWinsGoingSecond(duelsGoingSecond);
		int totalSecondLosses = DataMiner.getTotalLossesGoingSecond(duelsGoingSecond);
		int totalSecondDuels = totalSecondWins+totalSecondLosses;
		double secondWinrate = DataMiner.getTotalWinRateGoingSecond(duelsGoingSecond);
		int totalTurnsFromDuelsWithTurnCountSecond = DataMiner.getTotalTurnsFromDuelsWithTurnCount(duelsGoingSecond);
		int totalDuelsWithTurnCountSecond = DataMiner.getAmountOfDuelsWithTurnCount(duelsGoingSecond);
		double avgTurnsSecond = Calculator.calculateAverage(totalTurnsFromDuelsWithTurnCountSecond, totalDuelsWithTurnCountSecond);
		goingSecondWinRateLabel = new Label(0, labelY, 1920, 50, "Going Second  >>>  "
				+ "Wins: "+totalSecondWins+"  "
				+ "|  Losses: "+totalSecondLosses+"  "
				+ "|  ( "+totalSecondDuels+" )  -  "+df.format(secondWinrate)+"%  "
				+ "|  Avg. Turns: "+df.format(avgTurnsSecond)

				, 50, 200, 200, 255);
		panel.add(goingSecondWinRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		int totalCoinWins = DataMiner.getTotalCoinWins(listFilteredOnlySelectedSeason);
		int totalCoinLosses = DataMiner.getTotalCoinLosses(listFilteredOnlySelectedSeason);
		int totalCoinsThrow = totalCoinWins+totalCoinLosses;
		double coinWinrate = DataMiner.getTotalCoinWinRate(listFilteredOnlySelectedSeason);
		coinWinRateLabel = new Label(0, labelY, 1920, 50, "Coin toss win rate  >>>  "
				+ "Wins: "+totalCoinWins+"  "
				+ "|  Losses: "+totalCoinLosses+"  "
				+ "|  ( "+totalCoinsThrow+" )  -  "+df.format(coinWinrate)+"%"
				, 50, 200, 200, 255);
		panel.add(coinWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalDuelsGoingFirst = DataMiner.getTotalDuelsGoingFirst(listFilteredOnlySelectedSeason);
		int totalDuelsGoingSecond = DataMiner.getTotalDuelsGoingSecond(listFilteredOnlySelectedSeason);
		int totalDuelsAmount = totalDuelsGoingFirst+totalDuelsGoingSecond;
		double goingFirstFrequency = DataMiner.getTotalGoingFirstFrequencyPercentage(listFilteredOnlySelectedSeason);
		goingFirstFrequencyLabel = new Label(0, labelY, 1920, 50, "Play first frequency  >>>  "
				+ "First: "+totalDuelsGoingFirst+"  "
				+ "|  Second: "+totalDuelsGoingSecond+"  "
				+ "|  ( "+totalDuelsAmount+" )  -  "+df.format(goingFirstFrequency)+"%"
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
		
		if (e.getSource() == filterSeasonButton.getJComponent()) {
			String selectedSeason = seasonComboBox.getJComponent().getSelectedItem().toString();
			if (selectedSeason.equalsIgnoreCase("All Seasons")) {
				FrontEndInMemoryData.filteredSeason = 0;
			} else {
				String[] splitted = selectedSeason.split(" ");
				FrontEndInMemoryData.filteredSeason = Integer.valueOf(splitted[1]);
			}
			
			ViewDataPanel initialPanel = new ViewDataPanel(frame
					,FrontEndInMemoryData.getAllDuelsFromUser(),
					"All decks  vs  All decks");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
		
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