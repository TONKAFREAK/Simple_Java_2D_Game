package com.simple2dgame.main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.simple2dgame.main.Game.STATE;



public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	private Game game;
	public static int mouseX, mouseY;
	
	public MouseInput(Game game,Handler handler) {
		this.handler = handler;
		this.game = game;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int key = e.getButton();
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				if(game.gameState == STATE.Game) {
					
					if (key == MouseEvent.BUTTON1) {
						//DEBUG	System.out.println("Mouse clicked at "+mouseX+", "+mouseY);
							handler.addObject(new Bullet(tempObject.getX()+(7),tempObject.getY()+(7),ID.Bullet, new Guns(5,3,3,5,Color.cyan),handler));
						}
					
				}
				
				
				
				
			}
			
		}
		
		if(mouseOver(mouseX,mouseY,911, 14, 28, 58)){
			game.gameState = STATE.Menu;
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	//DEBUG	System.out.println("Mouse moved to (" + mouseX + ", " + mouseY + ")");
	}
	
	private boolean mouseOver(int mouseX,int mouseY, int x, int y, int width, int height) {
		if(mouseX > x && mouseX < x + width) {
			if (mouseY > y && mouseY < y + height) {
				return true;
			} return false;
		} return false;
		
	}
	
	public static int getMouseX () {
		return mouseX;
	}
	
	public static int getMouseY() {
		return mouseY;
	}
	
}
