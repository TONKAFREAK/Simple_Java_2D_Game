import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBasic extends GameObject{
	
	private GameObject player;
	
	private Handler handler;
	
	private int enemySpeed;
	
	private static int basicEnemyHealth = 30 ;
	

	public EnemyBasic(int x, int y, int speed, ID id,GameObject player, Handler handler) {
		super(x, y,basicEnemyHealth , id);
		this.player = player;
		this.enemySpeed = speed;
		this.handler = handler; 
		
	}

	
	@Override
	public void tick() {
	    // Calculate the vector from the enemy to the player
	    float diffX = player.getX() - x;
	    float diffY = player.getY() - y;
	    float distance = (float) Math.sqrt(diffX * diffX + diffY * diffY);

	    // Calculate the normalized direction vector
	    float dirX = (distance != 0) ? (diffX / distance) : 0;
	    float dirY = (distance != 0) ? (diffY / distance) : 0;

	    
	    int minVelocity = 0; // minimum speed
	    velX = (int) (dirX * enemySpeed);
	    velY = (int) (dirY * enemySpeed);

	    // Adjust velocity to ensure a minimum non-zero value
	    velX = (velX != 0) ? velX : (dirX > 0 ? minVelocity : -minVelocity);
	    velY = (velY != 0) ? velY : (dirY > 0 ? minVelocity : -minVelocity);

	    // Update the enemy's position based on the velocity
	    x += velX;
	    y += velY;

	    // Ensure the enemy stays within certain bounds
	    x = Game.clamp(x, 355, Game.WIDTH -368);
		y = Game.clamp(y, 115,Game.HEIGHT - 80);
		System.out.println("EnemyHealth "+health);
		if (health <= 0 ) {
			handler.removeObject(this);
		}
	}

	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
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
	
	public int getEnemySpeed() {
		return enemySpeed;
	}
	
	public int getBasicEnemyHealth() {
		return health;
	}
	
	public void setBasicEnemyHealth(int health) {
		
		this.health = health;
		
	}

}
