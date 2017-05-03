//Jframe that displays 
package minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Screen extends JFrame implements Runnable{

	private Mines field;
	
	//double buffering
	private Image dbImage;
	private Graphics dbg;
	
	//screen dimensions variables
	private final int SCREENX = 800, SCREENY = 500;
	
	//mouse x and y variables
	private int mouseX, mouseY;
	
	//the thread
	public void run() {
		
		try {
			
			while (true) {
				
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Error in thread: " + e.getMessage());
		}
		
	}
	
	//mouse input
	public class Mouse extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
			mouseX = e.getX();
			mouseY = e.getY();
			
			System.out.println("Mouse X: " + mouseX + " Mouse Y: " + mouseY);
			
		}
		
	}
	
	//key input
	public class Keyboard extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			if (key == e.VK_Q) {
				System.exit(0);
			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();
			
		}
		
	}
	
	//the default constructor, creates JFrame
	public Screen() {
		
		//creates mines object
		field = new Mines();
		
		//mouse listener
		addMouseListener(new Mouse());
		
		//key listener
		addKeyListener(new Keyboard());
		
		setTitle("Minesweeper");
		setVisible(true);
		setSize(SCREENX, SCREENY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//printing stuff to the screen
	public void paintComponent(Graphics g) {
		
		for (int r = 0; r < this.field.tiles.length; r++) {
			
			for (int c = 0; c < this.field.tiles[0].length; c++) {
				
				Tile item = this.field.tiles[r][c];
				//if (item.getIsHidden()) {
					g.fillRect(15 + r * 10, 30 + c * 10, 10, 10);
					g.setColor(Color.white);
					g.drawRect(15 + r * 10, 30 + c * 10, 10, 10);
					g.setColor(Color.black);
				//}
					
					
					
			/*added*/	 if(!item.getIsHidden() && item.getIsMine()){
					 g.fillRect(15 + r * 10, 30 + c * 10, 10, 10);
						g.setColor(Color.white);
						g.drawRect(15 + r * 10, 30 + c * 10, 10, 10);
					g.setColor(Color.orange);
				}
			/*added*/	else if(!item.getIsHidden() && !item.getIsMine()) {
				/*added*/		g.fillRect(15 + r * 10, 30 + c * 10, 10, 10);
				/*added*/		g.setColor(Color.white);
				/*added*/			g.drawRect(15 + r * 10, 30 + c * 10, 10, 10);
				/*added*/			g.setColor(Color.red);
				}
				
				
			}
			
		}
		
		g.drawString("Mouse X: " + mouseX + " Mouse Y:" + mouseY, 20, SCREENY - 100);
		
		int xbox = (mouseX -18) / 10;
		int ybox = (mouseY - 34) / 10;
		repaint();
		/*added*/	if(xbox > 0 && ybox > 0){
		/*added*/		g.drawString(xbox + " " + ybox,40,SCREENY - 120);
		
			/*added*/		field.tiles[xbox][ybox].show();
//		if(field.tiles[ybox][xbox].getIsMine()){
//			field.boom(field.tiles[ybox][xbox]);
//			
//		}
	
		}
		
	}
	
	//double buffering
	public void paint(Graphics g) {
		
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
}
