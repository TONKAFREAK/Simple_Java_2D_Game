package com.simple2dgame.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.simple2dgame.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private BufferedImage menuImage, FPS_ON , FPS_OFF;
	private HUD hud;
	
	private int mouseX, mouseY;
	
	public Menu(Game game, Handler handler, HUD hud) {
		
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		
		try {
			menuImage = ImageIO.read(getClass().getResource("/images/Menu.png"));
			FPS_ON = ImageIO.read(getClass().getResource("/images/buttons/FPS_ON.png"));
			FPS_OFF = ImageIO.read(getClass().getResource("/images/buttons/FPS_OFF.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if (game.gameState == STATE.Menu) {
			
			if(mouseOver(mouseX, mouseY, 561, 297, 169, 34 )) {
				game.gameState = STATE.Game;
			}
			
			//-------------------------------- RESTART Button --------------------------------
			
			if(mouseOver(mouseX, mouseY,561, 350, 169, 34 )) {
				
				game.gameState = STATE.Game;
				for(int i = 0; i < handler.object.size(); i++) {
					handler.object.remove(i);	
				}
				
				Player player = new Player(game.getWidth()/2-16,game.getHeight()/2-16,ID.Player, handler, hud);
				Player.setPlayerHealth(30);
				hud.setHealth(Player.playerHealth);
				
				System.out.println(Player.getPlayerHealth());
				handler.addObject(player);
				
				
				// add objects to the screen / game.
			    handler.addObject(new EnemyBasic(game.getWidth()/2-70,game.getHeight()/2-16,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2-70,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2+50,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2+90,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2-40,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
					} //-------------------------------------------------------------------------
			
			//-------------------------------------- EXIT Button --------------------------------
			
			if (mouseOver (mouseX, mouseY,561, 402, 169, 34 )) {
				
				System.exit(0);
				
					} //--------------------------------------------------------------------------
				
			if(mouseOver(mouseX, mouseY, 706,265,24,17 )) {
				
				Game.showFPS = !Game.showFPS;
				
			}
				}
		
			
		
		
	    }
		
		
		
		
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mouseX,int mouseY, int x, int y, int width, int height) {
		if(mouseX > x && mouseX < x + width) {
			if (mouseY > y && mouseY < y + height) {
				return true;
			} return false;
		} return false;
		
	}
	
	public int getMouseX () {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(new Color (19,19,21,250));
		g.fillRect( 0, 0, game.getWidth(), 720);
		
		g.drawImage(menuImage, 1280/2-113, 250, 226, 219, null);
		
		if(Game.showFPS) {
			g.drawImage(FPS_ON,706,265,24,17,null);
		} else {
			g.drawImage(FPS_OFF,706,265,24,17,null);
		}
		
		//resume / start button coordinates 
		
//		g.setColor(Color.yellow);
//		g.drawRect(561, 297, 169, 34);
		
		// restart
		
//		g.setColor(Color.red);
//		g.drawRect(561, 350, 169, 34);
		
		// exit button coordinates
		
//		g.setColor(Color.cyan);
//		g.drawRect(561, 402, 169, 34);
	}
}
