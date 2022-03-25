package br.com.joaofzm15.yugiohstats.gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.joaofzm15.yugiohstats.gui.config.Config;

public class Button implements FrameComponent, MouseListener {

	private JButton button;
	public JButton getJComponent() {
		return button;
	}

	public Button(double x, double y, double xSize, double ySize, String text, int red, int green, int blue) {
		button = new JButton();
		button.addMouseListener(this);
		button.setBounds((int) (x * Config.multiplier), (int) (y * Config.multiplier),
				(int) (xSize * Config.multiplier), (int) (ySize * Config.multiplier));
		button.setContentAreaFilled(false);
		button.setText(text);
		button.setForeground(new Color(red, green, blue));
//		button.setFont(new Font("Visitor TT1 BRK", Font.PLAIN, (int) (62 * Config.multiplier)));
		button.setFont(new Font("Impact", Font.PLAIN, (int) (62 * Config.multiplier)));
		button.setFocusable(false);
	
		button.setBorder(BorderFactory.createLineBorder(Color.white));
		button.setBorderPainted(false);
	}

	public void setVisible(boolean value) {
		getJComponent().setVisible(value);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		button.setForeground(new Color(0,80,255));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		button.setForeground(Color.WHITE);
	}
}
