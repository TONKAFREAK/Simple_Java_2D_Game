import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable  {
	
	private static final long serialVersionUID = -1442798787354930462L;
	
	public static final int WIDTH = 1280 , HEIGHT = 750; // WIDTH and HEIGHT of the window frame

	private Thread thread;
	private boolean running = false;
	private String title;
	private boolean showFPS = true;
	
	int frames = 0;
	
	private Handler handler;
	private HUD hud;
	
	private BufferedImage backgroundImage;
	
	public Game() {
		
		title = "Game"; // name of the window frame 
		
		handler = new Handler();
		
		hud = new HUD();
		
		MouseInput mouseInput = new MouseInput(handler);
	    this.addMouseListener(mouseInput);
	    this.addMouseMotionListener(mouseInput);
		this.addKeyListener(new KeyInput(handler));
		this.setFocusable(true);
		
		
		new Window(WIDTH,HEIGHT,title,this);
		
		try {
            backgroundImage = ImageIO.read(getClass().getResource("/images/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		// add the player to the game 
		Player player = new Player(WIDTH/2-16,HEIGHT/2-16,ID.Player, handler, hud);
		handler.addObject(player);
		// add objects to the screen / game.
	    handler.addObject(new EnemyBasic(WIDTH/2-70,HEIGHT/2-16,0,ID.EnemyBasic,player,handler));
	    handler.addObject(new EnemyBasic(WIDTH/2-70,HEIGHT/2-70,0,ID.EnemyBasic,player,handler));
	    handler.addObject(new EnemyBasic(WIDTH/2+50,HEIGHT/2-70,0,ID.EnemyBasic,player,handler));
	    handler.addObject(new EnemyBasic(WIDTH/2+90,HEIGHT/2-70,0,ID.EnemyBasic,player,handler));
	    handler.addObject(new EnemyBasic(WIDTH/2-40,HEIGHT/2-70,0,ID.EnemyBasic,player,handler));
	    
		
	    
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop() {
		
		try {
			thread.join();
			running = false;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() { // game loop , don't modify 
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0.0;
		
		long timer = System.currentTimeMillis();
		
		
		while(running) {
			
			long now = System.nanoTime();
			delta += ( now - lastTime ) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				
				tick();
				delta--;
				
			}
			
			if(running) {
				render();
				
			} 
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
			//	System.out.println("FPS: " + frames );
				frames = 0;
			}
	       }
		
			
		stop();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(backgroundImage, 0, 0, WIDTH, 720, null);
		
		handler.render(g);
		
		hud.render(g);
		
		// FPS
		
		if (showFPS) {
			
			g.setFont(new Font("Arial", Font.PLAIN, 15));
	        g.setColor(Color.white);
	        g.drawString("FPS: " + frames, 12, 26); 
		}
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		hud.tick();
		
	}
	
	public static int clamp( int var ,int min , int max) {
		if (var >= max) {
			return var = max;
		} else if(var <= min) {
			return var = min;
		} else {
			return var;
		}
	}
	
	
	public static void main(String args[]) {
		new Game();
	}

}
