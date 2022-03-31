package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Deck;
import br.com.joaofzm15.yugiohstats.backEnd.entitites.enums.OppDeck;
import br.com.joaofzm15.yugiohstats.frontEnd.exceptions.BlankFieldException;
import br.com.joaofzm15.yugiohstats.frontEnd.exceptions.FieldInputMismatchException;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.CheckBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.ComboBox;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Label;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.http.HttpController;
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

	private JFrame frame;
	
	public ViewDataPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		titleLabel = new Label(0, 170, 1920, 130, "STATS", 130, 200, 200, 255);
		panel.add(titleLabel);
		
		int totalWins = Calculator.calculateUserTotalWins();
		int totalLosses = Calculator.calculateUserTotalLosses();
		int totalDuels = totalWins+totalLosses;
		double winrate = Calculator.calculateUserTotalWinRate();
		winRateLabel = new Label(0, 320, 1920, 50, "Wins: "+totalWins+"  |  Losses: "+totalLosses+"  "
				+ "|  ("+totalDuels+")  -  "+winrate+"%"
				, 50, 200, 200, 255);
		panel.add(winRateLabel);

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