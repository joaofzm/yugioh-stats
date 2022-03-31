package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.Duel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Label;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.Calculator;
import br.com.joaofzm15.yugiohstats.frontEnd.logic.DataMiner;

public class ViewDataPanel implements ActionListener {

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
	
	public ViewDataPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		titleLabel = new Label(0, 170, 1920, 130, "GENERAL STATS", 130, 200, 200, 255);
		panel.add(titleLabel);
		
		//===============================================
		int labelY = 340;
		//===============================================
		int totalWins = DataMiner.getUserTotalWins();
		int totalLosses = DataMiner.getUserTotalLosses();
		int totalDuels = totalWins+totalLosses;
		double winrate = DataMiner.getUserTotalWinRate();
		winRateLabel = new Label(0, labelY, 1920, 50, "Total  >>>  "
				+ "Wins: "+totalWins+"  "
				+ "|  Losses: "+totalLosses+"  "
				+ "|  ( "+totalDuels+" )  -  "+winrate+"%"
				, 50, 200, 200, 255);
		panel.add(winRateLabel);
		//===============================================
		labelY+=150;
		//===============================================
		int totalFirstWins = DataMiner.getUserTotalWinsGoingFirst();
		int totalFirstLosses = DataMiner.getUserTotalLossesGoingFirst();
		int totalFirstDuels = totalFirstWins+totalFirstLosses;
		double firstWinrate = DataMiner.getUserTotalWinRateGoingFirst();
		goingFirstWinRateLabel = new Label(0, labelY, 1920, 50, "Going Fist  >>>  "
				+ "Wins: "+totalFirstWins+"  "
				+ "|  Losses: "+totalFirstLosses+"  "
				+ "|  ( "+totalFirstDuels+" )  -  "+firstWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingFirstWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalSecondWins = DataMiner.getUserTotalWinsGoingSecond();
		int totalSecondLosses = DataMiner.getUserTotalLossesGoingSecond();
		int totalSecondDuels = totalSecondWins+totalSecondLosses;
		double secondWinrate = DataMiner.getUserTotalWinRateGoingSecond();
		goingSecondWinRateLabel = new Label(0, labelY, 1920, 50, "Going Second  >>>  "
				+ "Wins: "+totalSecondWins+"  "
				+ "|  Losses: "+totalSecondLosses+"  "
				+ "|  ( "+totalSecondDuels+" )  -  "+secondWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(goingSecondWinRateLabel);
		//===============================================
		labelY+=205;
		//===============================================
		int totalCoinWins = DataMiner.getUserTotalCoinWins();
		int totalCoinLosses = DataMiner.getUserTotalCoinLosses();
		int totalCoinsThrow = totalCoinWins+totalCoinLosses;
		double coinWinrate = DataMiner.getUserTotalCoinWinRate();
		coinWinRateLabel = new Label(0, labelY, 1920, 50, "Coin toss  >>>  "
				+ "Wins: "+totalCoinWins+"  "
				+ "|  Losses: "+totalCoinLosses+"  "
				+ "|  ( "+totalCoinsThrow+" )  -  "+coinWinrate+"%"
				, 50, 200, 200, 255);
		panel.add(coinWinRateLabel);
		//===============================================
		labelY+=75;
		//===============================================
		int totalDuelsGoingFirst = DataMiner.getUserTotalDuelsGoingFirst();
		int totalDuelsGoingSecond = DataMiner.getUserTotalDuelsGoingSecond();
		int totalDuelsAmount = totalDuelsGoingFirst+totalDuelsGoingSecond;
		double goingFirstFrequency = DataMiner.getUserTotalGoingFirstFrequencyPercentage();
		goingFirstFrequencyLabel = new Label(0, labelY, 1920, 50, "Coin toss  >>>  "
				+ "Duels going first: "+totalDuelsGoingFirst+"  "
				+ "|  Duels going second: "+totalDuelsGoingSecond+"  "
				+ "|  ( "+totalDuelsAmount+" )  -  "+goingFirstFrequency+"%"
				, 50, 200, 200, 255);
		panel.add(goingFirstFrequencyLabel);
		
		
		
		
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnButton.getJComponent()) {
			MenuPanel initialPanel = new MenuPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
	}
}