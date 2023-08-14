package com.simple2dgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.simple2dgame.main.Game.STATE;

public class StartMenu extends MouseAdapter{
	
	private int mouseX , mouseY;
	
	private BufferedImage backgroundImage;
	private Game game;
	private Handler handler;
	private HUD hud;
	
	public StartMenu(Game game, Handler handler, HUD hud) {
		
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if (game.gameState == STATE.Start) {
			
			if(mouseOver(mouseX,mouseY,561, 314, 169, 34)) {
				game.gameState = STATE.Game;
				
				
				Player player = new Player(game.getWidth()/2-16,game.getHeight()/2-16,ID.Player, handler, hud);
				
				handler.addObject(player);
				
				
				// add objects to the screen / game.
			    handler.addObject(new EnemyBasic(game.getWidth()/2-70,game.getHeight()/2-16,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2-70,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2+50,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2+90,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    handler.addObject(new EnemyBasic(game.getWidth()/2-40,game.getHeight()/2-70,0,ID.EnemyBasic,player,handler));
			    
				}
			
			if(mouseOver(mouseX, mouseY, 561, 371, 169, 35 )) {
				System.exit(0);
			}
			}
		
			
	    }
	
	public void tick() {
		
	}
	
	
	public void render(Graphics g) {
		try {
			backgroundImage = ImageIO.read(getClass().getResource("/images/startMenu2.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		g.setColor(new Color(146,131,196));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.drawImage(backgroundImage, 1280/2-113, 250, 226, 219, null);
		
		//-------------START BUTTON ---------------
		
	//	g.setColor(Color.yellow);
	//	g.drawRect(561, 314, 169, 34);
		
		//--------------- EXIT BUTTON ----------------
		
	//	g.setColor(Color.red);
	//	g.drawRect(561, 371, 169, 35);
	}
	
	private boolean mouseOver(int mouseX,int mouseY, int x, int y, int width, int height) {
		if(mouseX > x && mouseX < x + width) {
			if (mouseY > y && mouseY < y + height) {
				return true;
			} return false;
		} return false;
		
	}
}
