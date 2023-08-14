package com.simple2dgame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

	
public class HUD {
	
	private BufferedImage HP_3, HP_25 , HP_2, HP_15, HP_1, HP_05, HP_0, menuButtonImage;
	

	int health = Player.getPlayerHealth();
		
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
		
	}
	
	public void tick() {
		health = Game.clamp(health, 0, 30);
		
	}
	
	public void render(Graphics g) {
		
		// HP Bar
		
		try {
			menuButtonImage = ImageIO.read(getClass().getResource("/images/buttons/menu_button.gif"));
            HP_3 = ImageIO.read(getClass().getResource("/images/HP/3_HP.png"));
            HP_25 = ImageIO.read(getClass().getResource("/images/HP/2.5_HP.png"));
            HP_2 = ImageIO.read(getClass().getResource("/images/HP/2_HP.png"));
            HP_15 = ImageIO.read(getClass().getResource("/images/HP/1.5_HP.png"));
            HP_1 = ImageIO.read(getClass().getResource("/images/HP/1_HP.png"));
            HP_05 = ImageIO.read(getClass().getResource("/images/HP/0.5_HP.png"));
            HP_0 = ImageIO.read(getClass().getResource("/images/HP/0_HP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		g.drawImage(menuButtonImage, 900,14, 50, 58, null);
		
		if (health >= 30 ) {
			
			g.drawImage(HP_3, 350, 28, 95, 30, null);
			
		} else if (health < 30 && health >=25) {
			
			g.drawImage(HP_25, 350, 28, 95, 30, null);
			
		} else if (health < 25 && health >=20) {
			
			g.drawImage(HP_2, 350, 28, 95, 30, null);
			
		} else if (health < 20 && health >=15) {
			
			g.drawImage(HP_15, 350, 28, 95, 30, null);
			
		} else if (health < 15 && health >=10) {
			
			g.drawImage(HP_1, 350, 28, 95, 30, null);
			
		} else if (health < 10 && health >= 5) {
			
			g.drawImage(HP_05, 350, 28, 95, 30, null);
			
		} else {
			
			g.drawImage(HP_0, 350, 28, 95, 30, null);
			
		}
		
//		//---------MENU BUTTON
//		
//		g.setColor(Color.yellow);
//		g.drawRect(911, 14, 28, 58);
		
//		g.setColor(Color.gray);
//		g.fillRect(350, 30, 60, 12);
//		
//		g.setColor(Color.red);
//		g.fillRect(350, 30, health-40, 12);
//		
//		g.setColor(Color.white);
//		g.drawRect(350, 30, 60, 12);
		
}
}
