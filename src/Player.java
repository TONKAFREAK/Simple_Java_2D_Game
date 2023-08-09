import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void tick() { // player movement / speed	
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g)  { // player texture / image
		g.setColor(Color.white);
		g.fillRect(x,y,16,16);
		
	}

}
