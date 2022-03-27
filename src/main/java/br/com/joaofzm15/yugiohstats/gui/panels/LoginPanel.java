package br.com.joaofzm15.yugiohstats.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.joaofzm15.yugiohstats.entitites.Player;
import br.com.joaofzm15.yugiohstats.gui.components.Button;
import br.com.joaofzm15.yugiohstats.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.gui.config.Config;
import br.com.joaofzm15.yugiohstats.repositories.PlayerRepository;

public class LoginPanel implements ActionListener {

	private Panel panel;
	public Panel getPanel() {
		return panel;
	}
	
	private JLabel bg;
	
	private TextField usernameTextField;
	private TextField passwordTextField;
	
	private Button loginButton;
	private Button registerButton;
	private Button exitButton;

	private JFrame frame;
	
	public LoginPanel(JFrame frame) {
		
		this.frame=frame;

		panel = new Panel(1920,1080);
		
		usernameTextField = new TextField(828, 550, 264, 56, "                 username",28);
		usernameTextField.getJComponent().addActionListener(this);
		panel.add(usernameTextField);

		passwordTextField = new TextField(828, 650, 264, 56, "                  password",28);
		passwordTextField.getJComponent().addActionListener(this);
		panel.add(passwordTextField);
		
		loginButton = new Button(869, 750, 182, 56, "SIGN IN",20,255,20,62);
		loginButton.getJComponent().addActionListener(this);
		panel.add(loginButton);
		
		registerButton = new Button(815, 850, 290, 56, "CREATE ACCOUNT",20,160,20,42);
		registerButton.getJComponent().addActionListener(this);
		panel.add(registerButton);

		exitButton = new Button(908, 950, 104, 56, "EXIT",255,20,20,62);
		exitButton.getJComponent().addActionListener(this);
		panel.add(exitButton);
		
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

		if (e.getSource() == loginButton.getJComponent()) {
			MenuPanel initialPanel = new MenuPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
		
		if (e.getSource() == registerButton.getJComponent()) {
			System.out.println("Create new account!");
		}
		
		if (e.getSource() == exitButton.getJComponent()) {
			try {
				Thread.sleep(900);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

}