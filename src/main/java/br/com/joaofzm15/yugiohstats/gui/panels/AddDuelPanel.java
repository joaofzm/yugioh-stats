package br.com.joaofzm15.yugiohstats.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.joaofzm15.yugiohstats.gui.components.Button;
import br.com.joaofzm15.yugiohstats.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.gui.components.Label;
import br.com.joaofzm15.yugiohstats.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.gui.config.Config;

public class AddDuelPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private TextField loginTextField;
	private TextField passwordTextField;
	
	private Button loginButton;
	private Button exitButton;

	private JFrame frame;
	
	public AddDuelPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		loginTextField = new TextField(828, 550, 264, 56, "                username");
		loginTextField.getJComponent().addActionListener(this);
		panel.add(loginTextField);

		passwordTextField = new TextField(828, 650, 264, 56, "                 password");
		passwordTextField.getJComponent().addActionListener(this);
		panel.add(passwordTextField);
		
		loginButton = new Button(869, 750, 182, 56, "SIGN IN",20,255,20);
		loginButton.getJComponent().addActionListener(this);
		panel.add(loginButton);

		exitButton = new Button(865, 950, 190, 56, "RETURN",255,20,20);
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

//		new Thread(new ClickSound()).start();

		if (e.getSource() == loginButton.getJComponent()) {

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