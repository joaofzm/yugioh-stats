package br.com.joaofzm15.yugiohstats.frontEnd.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.joaofzm15.yugiohstats.backEnd.entitites.Player;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Button;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.Panel;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.components.TextField;
import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;
import br.com.joaofzm15.yugiohstats.frontEnd.http.FrontEndInMemoryData;
import br.com.joaofzm15.yugiohstats.frontEnd.http.HttpController;

public class RegisterAccountPanel implements ActionListener {

	private Panel panel;

	public Panel getPanel() {
		return panel;
	}

	private JLabel bg;

	private TextField usernameTextField;
	private TextField passwordTextField;

	private Button registerButton;
	private Button returnButton;

	private JFrame frame;

	public RegisterAccountPanel(JFrame frame) {

		this.frame = frame;

		panel = new Panel(1920, 1080);

		usernameTextField = new TextField(828, 450, 264, 56, "                 username", 28);
		usernameTextField.getJComponent().addActionListener(this);
		panel.add(usernameTextField);

		passwordTextField = new TextField(828, 550, 264, 56, "                  password", 28);
		passwordTextField.getJComponent().addActionListener(this);
		panel.add(passwordTextField);

		registerButton = new Button(815, 650, 290, 56, "CREATE", 20, 160, 20, 42);
		registerButton.getJComponent().addActionListener(this);
		panel.add(registerButton);

		returnButton = new Button(865, 950, 190, 56, "RETURN", 255, 20, 20, 62);
		returnButton.getJComponent().addActionListener(this);
		panel.add(returnButton);

		bg = new JLabel();

		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/bg1280x720.png"));
		bg.setSize(1920, 1080);
		if (Config.res == 2) {
			icon = new ImageIcon(getClass().getClassLoader().getResource("Backgrounds/bg1280x720.png"));
			bg.setSize(1280, 720);
		}
		bg.setIcon(icon);
		panel.getJComponent().add(bg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == registerButton.getJComponent()) {
			if (usernameTextField.getJComponent().getText().equals("                 username")) {
				JOptionPane.showMessageDialog(null, "ERROR! Please type an username!");
			} else {
				HttpController.post("{\"name\": \"" + usernameTextField.getJComponent().getText() + "\"}}",
						"http://localhost:8080/players");
				JOptionPane.showMessageDialog(null, "Account created!");
			}
		}

		if (e.getSource() == returnButton.getJComponent()) {
			LoginPanel initialPanel = new LoginPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(initialPanel.getPanel().getJComponent());
			frame.revalidate();
			initialPanel.getPanel().getJComponent().repaint();
		}
	}

}