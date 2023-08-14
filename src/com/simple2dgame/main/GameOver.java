package com.simple2dgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

public class GameOver extends MouseAdapter {
	
	public void tick() {
		
	}

	public void render(Graphics g) {
			
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.white);
		g.drawString("Game Over", Game.WIDTH/2, Game.HEIGHT/2);
	}
	
}
