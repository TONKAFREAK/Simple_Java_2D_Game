import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// key events for ID Player
				
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) { 
					tempObject.setVelY(-4); // press 'w' or 'up' to go up by 1 
				}
				else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					tempObject.setVelY(+4); // press 's' or 'down' to down up by 1 
				}
				else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(+4); // press 'd' or 'right' to go up by 1 
				}
				else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-4); // press 'a' or 'left' to go up by 1 
				}  
				if (key == KeyEvent.VK_ESCAPE) System.exit(0);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				// key events for ID Player
				
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					tempObject.setVelY(0);
				}
				else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					tempObject.setVelY(0);
				}
				else if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
				else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
			}
		}
		
		
	}

}
