import java.awt.Color;
import java.awt.Graphics;

	
public class HUD {
	
	int health = Player.getPlayerHealth();
		
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
		
	}
	
	public void tick() {
		health = Game.clamp(health, 0, 100);
	}
	
	public void render(Graphics g) {
		
		// HP Bar
		
		g.setColor(Color.gray);
		g.fillRect(350, 30, 60, 12);
		
		g.setColor(Color.red);
		g.fillRect(350, 30, health-40, 12);
		
		g.setColor(Color.white);
		g.drawRect(350, 30, 60, 12);
		
}
}
