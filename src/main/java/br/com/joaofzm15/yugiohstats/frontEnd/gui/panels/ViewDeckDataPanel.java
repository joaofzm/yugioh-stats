package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.ComboBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Label;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.Calculator;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DataMiner;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DuelListFilter;

public class ViewDeckDataPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private Button returnButton;
	
	private Label titleLabel;
	
	private Label winRateLabel;
	private Label goingFirstWinRateLabel;
	private Label goingSecondWinRateLabel;
	
	private Label coinWinRateLabel;
	private Label goingFirstFrequencyLabel;

	private JFrame frame;
	
	
	public ViewDeckDataPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		titleLabel = new Label(0, 70, 1920, 130
				, FrontEndInMemoryData.currentlyViewdDeck.getName()+" STATS"
				, 130, 200, 200, 255);
		panel.add(titleLabel);
		
		returnButton = new Button(865, 950, 190, 56, "RETURN",255,20,20,62);
		returnButton.getJComponent().addActionListener(this);
		panel.add(returnButton);
		
		
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		//===============================================
		List<Duel> allDuelsFromSelectedDeck = FrontEndInMemoryData.currentlyViewdDeck.getDuels();
		int labelY = 270;
		//===============================================
		int totalWins = DataMiner.getTotalWins(allDuelsFromSelectedDeck);
		int totalLosses = DataMiner.getTotalLosses(allDuelsFromSelectedDeck);
		int totalDuels = totalWins+totalLosses;
		double winrate = DataMiner.getTotalWinRate(allDuelsFromSelectedDeck);
		winRateLabel = new Label(0, labelY, 1920, 50, "Total  >>>  "
				+ "Wins: "+totalWins+"  "
				+ "|  Losses: "+totalLosses+"  "
				+ "|  ( "+totalDuels+" )  -  "+winrate+"%"
				, 50, 200, 200, 255);
		panel.add(winRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		int totalFirstWins = DataMiner.getTotalWinsGoingFirst(allDuelsFromSelectedDeck);
		int totalFirstLosses = DataMiner.getTotalLossesGoingFirst(allDuelsFromSelectedDeck);
		int totalFirstDuels = totalFirstWins+totalFirstLosses;
		double firstWinrate = DataMiner.getTotalWinRateGoingFirst(allDuelsFromSelectedDeck);
		goingFirstWinRateLabel = new Label(0, labelY, 1920, 50, "Going Fist  >>>  "
				+ "Wins: "+totalFirstWins+"  "
				+ "|  Losses: "+totalFirstLosses+"  "
				+ "|  ( "+totalFirstDuels+" )  -  "+firstWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingFirstWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalSecondWins = DataMiner.getTotalWinsGoingSecond(allDuelsFromSelectedDeck);
		int totalSecondLosses = DataMiner.getTotalLossesGoingSecond(allDuelsFromSelectedDeck);
		int totalSecondDuels = totalSecondWins+totalSecondLosses;
		double secondWinrate = DataMiner.getTotalWinRateGoingSecond(allDuelsFromSelectedDeck);
		goingSecondWinRateLabel = new Label(0, labelY, 1920, 50, "Going Second  >>>  "
				+ "Wins: "+totalSecondWins+"  "
				+ "|  Losses: "+totalSecondLosses+"  "
				+ "|  ( "+totalSecondDuels+" )  -  "+secondWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingSecondWinRateLabel);
		//===============================================
		labelY+=110;
		//===============================================
		int totalCoinWins = DataMiner.getTotalCoinWins(allDuelsFromSelectedDeck);
		int totalCoinLosses = DataMiner.getTotalCoinLosses(allDuelsFromSelectedDeck);
		int totalCoinsThrow = totalCoinWins+totalCoinLosses;
		double coinWinrate = DataMiner.getTotalCoinWinRate(allDuelsFromSelectedDeck);
		coinWinRateLabel = new Label(0, labelY, 1920, 50, "Coin toss win rate  >>>  "
				+ "Wins: "+totalCoinWins+"  "
				+ "|  Losses: "+totalCoinLosses+"  "
				+ "|  ( "+totalCoinsThrow+" )  -  "+coinWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(coinWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalDuelsGoingFirst = DataMiner.getTotalDuelsGoingFirst(allDuelsFromSelectedDeck);
		int totalDuelsGoingSecond = DataMiner.getTotalDuelsGoingSecond(allDuelsFromSelectedDeck);
		int totalDuelsAmount = totalDuelsGoingFirst+totalDuelsGoingSecond;
		double goingFirstFrequency = DataMiner.getTotalGoingFirstFrequencyPercentage(allDuelsFromSelectedDeck);
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		

			
		if (e.getSource() == returnButton.getJComponent()) {
			FrontEndInMemoryData.stopViewingDeck();
			ViewDataPanel initialPanel = new ViewDataPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
	}
}