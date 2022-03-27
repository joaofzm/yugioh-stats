package br.com.joaofzm15.yugiohstats.frontEnd.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.com.joaofzm15.yugiohstats.frontEnd.gui.config.Config;

public class ComboBox implements FrameComponent {

	private JComboBox<String> comboBox;
	public JComboBox<String> getJComponent() {
		return comboBox;
	}
	
	public ComboBox(double x, double y, double xSize, double ySize, String text,
			int foreGroundRed, int foreGroundGreen, int foreGroundBlue,
			int backGroundRed, int backGroundGreen, int backGroundBlue, int fontSize) {
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds((int) (x * Config.multiplier), (int) (y * Config.multiplier),
				(int) (xSize * Config.multiplier), (int) (ySize * Config.multiplier));
//		comboBox.setText(text);
		comboBox.setForeground(new Color(foreGroundRed, foreGroundGreen, foreGroundBlue));
		comboBox.setBackground(new Color(backGroundRed, backGroundGreen, backGroundBlue));
		comboBox.setFont(new Font("Impact", Font.PLAIN, (int) (fontSize * Config.multiplier)));
		comboBox.setFocusable(false);
	
		comboBox.setBorder(BorderFactory.createLineBorder(Color.white));
//		comboBox.setBorderPainted(true);
		
		comboBox.setVisible(true);
	}

	public void setVisible(boolean value) {
		getJComponent().setVisible(value);
	}

}