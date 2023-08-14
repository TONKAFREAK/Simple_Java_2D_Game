package com.simple2dgame.main;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Bullet extends GameObject {

    
    private Handler handler;
    private Guns gun;
    
    private int playerX, playerY;

    public Bullet(int x, int y, ID id,Guns gun, Handler handler) {
        super(x, y,0, id);
        this.handler = handler;
        this.gun = gun;

        // Calculate the angle between the bullet's starting position and the cursor
        double angle = Math.atan2(MouseInput.getMouseY() - y , MouseInput.getMouseX() - x );
        System.out.println(MouseInput.getMouseX()+" "+MouseInput.getMouseY());
        // Set the velocity components based on the calculated angle
        setVelX((int) (gun.getBulletSpeed() * Math.cos(angle)));
        setVelY((int) (gun.getBulletSpeed() * Math.sin(angle)));
    }

    @Override
    public void tick() {
        // Update the bullet's position based on its velocity
        x += getVelX();
        y += getVelY();
        
        for(int i = 0; i < handler.object.size(); i++){
		   GameObject tempObject = handler.object.get(i);
		   if (tempObject.getId() == ID.Player) {
			   
			   	playerX = tempObject.getX();
			   	playerY = tempObject.getY();
			  //DEBUG 	System.out.println("Player coordinates("+playerX+","+playerY+")");
				}
			}
        // Remove the bullet if it goes out of bounds
     
        if (x < playerX - 150 || x > playerX + 150 || x < 355 || x > Game.WIDTH -369  || y < 115 || y > Game.HEIGHT - 75 || y < playerY - 150 || y > playerY + 150) {
            // If the bullet is out of bounds, remove it from the game
            handler.removeObject(this);
        }
        collision();
    }
    
    private void collision() {
		for(int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.EnemyBasic) {
				if(getBounds().intersects(tempObject.getBounds())) {
					// collision code
					int enemyHealth = tempObject.getHealth();
					enemyHealth -= gun.getDamage();
					tempObject.setHealth(enemyHealth);
					handler.removeObject(this);
					
					
				}
			} 
		}
	}

    @Override
    public void render(Graphics g) {
        g.setColor(gun.getColor());
        g.fillRect(x, y, gun.getBulletWidth(), gun.getBulletHeight());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, gun.getBulletWidth(), gun.getBulletHeight());
    }
}
