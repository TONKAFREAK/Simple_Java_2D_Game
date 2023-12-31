package com.simple2dgame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.simple2dgame.main.Game.STATE;

public class Player extends GameObject {
	
	Handler handler;
	HUD hud ;
	public static int playerHealth = 30;
	public BufferedImage playerImage;
	public Player(int x, int y, ID id, Handler handler,HUD hud) {
		super(x, y,playerHealth, id);
		this.handler = handler;
		this.hud = hud;
	}

	@Override
	public void tick() { // player movement 
		x += velX;
		y += velY;
		
		// set boundary for player
		
		x = Game.clamp(x, 355, Game.WIDTH -369);
		y = Game.clamp(y, 115,Game.HEIGHT - 80);
		//System.out.println(playerHealth);
		collision();
		
		if (playerHealth <= 0) {
			Game.gameState = STATE.GameOver;
		}
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.EnemyBasic) {
				if(getBounds().intersects(tempObject.getBounds())) {
					// collision code
					int damage = EnemyBasic.getBasicEnemyDamage();
					playerHealth -= damage;
					hud.setHealth(playerHealth);
					handler.removeObject(tempObject);
					
					
				}
			} 
		}
	}

	@Override
	public void render(Graphics g)  { // player texture / image
		
//		try {
//			playerImage = ImageIO.read(getClass().getResource("/images/coolWater.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		g.setColor(Color.white);
		g.fillRect(x, y, 16, 16);
		
// 		debug		
//		g.setColor(Color.yellow);
//	    Rectangle bounds = getBounds(); // Get the bounding rectangle   
//	    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}
	
	public static int getPlayerHealth() {
		return playerHealth;
	}
	
	public static void setPlayerHealth(int health) {
		playerHealth = health;
	}


}
