package com.simple2dgame.main;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	
	private static final long serialVersionUID = -1371709396981101125L;

	protected int posX, posY, buttonWidth, buttonHeight;
	
	protected JButton button;
	
	protected String fileDir;
	
	protected boolean setBorderPainted = false;
	protected boolean setFocusPainted = false;
	protected boolean setContentAreaFilled = false;

	public Button(String fileDir, int posX, int posY, int buttonWidth, int buttonHeight) {
        this.fileDir = fileDir;
        this.posX = posX;
        this.posY = posY;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        ImageIcon image = new ImageIcon(fileDir);
        this.setIcon(image);
        this.setBorderPainted(setBorderPainted);
        this.setFocusPainted(setFocusPainted);
        this.setContentAreaFilled(setContentAreaFilled);
        this.setBounds(posX, posY, buttonWidth, buttonHeight);
        this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        
        String lastThreeLetters = fileDir.substring(fileDir.length() - 3);
        if (lastThreeLetters.equalsIgnoreCase("gif")) {
            this.addActionListener(e -> {
                if (image.getImageObserver() != null) {
                    image.getImageObserver().imageUpdate(image.getImage(), 0, 0, 0, 0, 0);
                }
            });
        }
    }
	
	public Button(JButton button, String fileDir, int posX, int posY, int buttonWidth, int buttonHeight, boolean setBorderPainted, boolean setFocusPainted, boolean setContentAreaFilled  ) {
		
		this.button = button;
		this.fileDir = fileDir;
		this.posX = posX;
		this.posY = posY;
		this.buttonWidth = buttonWidth;
		this.buttonHeight = buttonHeight;
		
		ImageIcon image = new ImageIcon(fileDir);
		button = new JButton (image);
		button.setBorderPainted(setBorderPainted);
		button.setFocusPainted(setFocusPainted);
		button.setContentAreaFilled(setContentAreaFilled);
		button.setBounds(posX, posY, buttonWidth, buttonHeight);
		
		String lastThreeLetters = fileDir.substring(fileDir.length() - 3);
		if (lastThreeLetters.equals("gif") || lastThreeLetters.equals("GIF") ) {
			button.addActionListener(e -> {
	            if (image.getImageObserver() != null) {
	            	image.getImageObserver().imageUpdate(image.getImage(), 0, 0, 0, 0, 0);
	            }
	        });
		}
		
	}
	
}
