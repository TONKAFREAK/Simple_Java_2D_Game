import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	public static int mouseX, mouseY;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int key = e.getButton();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				
				if (key == MouseEvent.BUTTON1) {
				//DEBUG	System.out.println("Mouse clicked at "+mouseX+", "+mouseY);
					handler.addObject(new Bullet(tempObject.getX(),tempObject.getY(),ID.Bullet, new Guns(5,2,3,20,Color.cyan),handler));
				}
			}
			
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	//DEBUG	System.out.println("Mouse moved to (" + mouseX + ", " + mouseY + ")");
	}
	
	public static int getMouseX () {
		return mouseX;
	}
	
	public static int getMouseY() {
		return mouseY;
	}
}
