package com.simple2dgame.main;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends Canvas {
	// class for the window frame 
	private static final long serialVersionUID = 9034494958129720942L;

	public Window(int width, int height, String title,Game game, JPanel panel){
		
		JFrame frame = new JFrame(title);
		ImageIcon img = new ImageIcon(getClass().getResource("/images/logoPiskel64x64.png"));
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setIconImage(img.getImage());
		game.start();
		
	//	frame.add(button);
		
	}
	
}
